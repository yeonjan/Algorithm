package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_2178_미로탐색 {
	static int n, m;
	static int[][] dist;
	static int[][] map;
	static int[][] delta = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		dist = new int[n][m];

		for (int i = 0; i < n; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = input[j] - '0';
				dist[i][j] = n * m;
			}
		}
		bfs();
		System.out.println(dist[n - 1][m - 1]);
	}

	public static void bfs() {
		ArrayDeque<int[]> queue = new ArrayDeque<>();

		dist[0][0] = 1;
		queue.offer(new int[] {0, 0});
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();

			for (int d = 0; d < 4; d++) {
				int dr = poll[0] + delta[d][0];
				int dc = poll[1] + delta[d][1];

				if (check(dr, dc))
					continue;

				if (map[dr][dc] == 1) {
					int newDist = dist[poll[0]][poll[1]] + 1;
					if (dist[dr][dc] > newDist) {
						queue.offer(new int[] {dr, dc, newDist});
						dist[dr][dc] = newDist;
					}
				}
			}

		}

	}

	public static boolean check(int dr, int dc) {
		return dr < 0 || dc < 0 || dr >= n || dc >= m;
	}
}
