package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_7569_토마토 {
	static int m, n, h, day = 0;
	static int[][][] map;
	static boolean flag;
	static boolean[][][] visited;
	static int[][] delta = {{0, 0, 1}, {0, 0, -1}, {-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}};
	static ArrayDeque<int[]> queue = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		map = new int[h][n][m];
		visited = new boolean[h][n][m];
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					int tomato = Integer.parseInt(st.nextToken());
					map[k][i][j] = tomato;
					if (tomato == 1) {
						queue.offer(new int[] {k, i, j});
						visited[k][i][j] = true;

					}
				}
			}
		}

		bfs();
		System.out.println(flag ? day : -1);

	}

	public static void bfs() {
		while (!queue.isEmpty()) {
			int size = queue.size();
			if (isEnd()) {
				flag = true;
				break;
			}
			day++;

			for (int cnt = 0; cnt < size; cnt++) {
				int[] poll = queue.poll();
				for (int i = 0; i < 6; i++) {
					int dh = poll[0] + delta[i][0];
					int dr = poll[1] + delta[i][1];
					int dc = poll[2] + delta[i][2];

					if (check(dr, dc, dh))
						continue;

					if (!visited[dh][dr][dc] && map[dh][dr][dc] == 0) {
						visited[dh][dr][dc] = true;
						queue.offer(new int[] {dh, dr, dc});
						map[dh][dr][dc] = 1;
					}
				}
			}
		}

	}

	private static boolean check(int dr, int dc, int dh) {
		return dr < 0 || dr >= n || dc < 0 || dc >= m || dh < 0 || dh >= h;
	}

	public static boolean isEnd() {
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[k][i][j] == 0)
						return false;
				}
			}
		}
		return true;
	}
}

//익은 토마토 다 넣기
// bfs depth 계산 하면서 돌기
// 한 뎊스마다 끝났는지 확인
