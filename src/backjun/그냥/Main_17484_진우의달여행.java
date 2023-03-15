package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17484_진우의달여행 {
	static int n;
	static int m;
	static int min = Integer.MAX_VALUE;
	static int[][] delta = {{1, -1}, {1, 0}, {1, 1}};
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < m; i++) {
			dfs(new int[] {0, i}, -1, map[0][i]);
		}

		System.out.println(min);

	}

	public static void dfs(int[] pos, int lastD, int w) {
		if (pos[0] >= n - 1) {
			min = Math.min(w, min);
			return;
		}

		for (int i = 0; i < 3; i++) {
			if (i == lastD)
				continue;

			int dr = pos[0] + delta[i][0];
			int dc = pos[1] + delta[i][1];

			if (dr < 0 || dc < 0 || dr >= n || dc >= m)
				continue;

			dfs(new int[] {dr, dc}, i, w + map[dr][dc]);

		}

	}
}
