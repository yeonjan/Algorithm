package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_2468_안전영역 {
	static int n;
	static int h = 0;
	static int max = 0;
	static int ans = 0;
	static int[][] map;
	static int[][] delta = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}

		while (h < max) {
			int area = 0;
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j] && map[i][j] > h) {
						bfs(i, j);
						area++;
					}
				}
			}
			ans = Math.max(ans, area);
			h++;
		}

		System.out.println(ans);

	}

	public static void bfs(int r, int c) {
		LinkedList<int[]> queue = new LinkedList<>();

		queue.offer(new int[] {r, c});
		visited[r][c] = true;

		while (!queue.isEmpty()) {
			int[] poll = queue.poll();

			for (int d = 0; d < 4; d++) {
				int dr = poll[0] + delta[d][0];
				int dc = poll[1] + delta[d][1];

				if (dr < 0 || dc < 0 || dr >= n || dc >= n) {
					continue;
				}
				if (!visited[dr][dc] && map[dr][dc] > h) {
					visited[dr][dc] = true;
					queue.offer(new int[] {dr, dc});

				}

			}
		}

	}
}
