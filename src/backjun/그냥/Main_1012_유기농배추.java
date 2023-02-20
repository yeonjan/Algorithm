package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_1012_유기농배추 {
	static int[][] delta = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
	static int[][] map;
	static boolean[][] visited;
	static int n, m, T, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());

			map = new int[n][m];
			visited=new boolean[n][m];
			int k = Integer.parseInt(st.nextToken());
			for (int i = 0; i < k; i++) {
				String[] input = br.readLine().split(" ");
				map[Integer.parseInt(input[1])][Integer.parseInt(input[0])] = 1;
			}

			cnt = 0;
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < m; c++) {
					if (!visited[r][c] && map[r][c] == 1) {
						bfs(r, c);
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	public static void bfs(int r, int c) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		visited[r][c] = true;
		queue.add(new int[] {r, c});

		while (!queue.isEmpty()) {
			int[] poll = queue.poll();

			for (int d = 0; d < 4; d++) {
				int dr = poll[0] + delta[d][0];
				int dc = poll[1] + delta[d][1];

				if (check(dr, dc))
					continue;

				if (!visited[dr][dc] && map[dr][dc] == 1) {
					visited[dr][dc] = true;
					queue.offer(new int[] {dr, dc});
				}

			}
		}

	}

	public static boolean check(int r, int c) {
		return r < 0 || c < 0 || r >= n || c >= m;
	}

}
