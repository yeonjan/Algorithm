package backjun.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500_테트로미노 {
	static int n, m;
	static int max = 0;
	static int[][] map;
	static boolean[][] visit;
	static int[][] delta = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visit[i][j]=true;
				dfs(i, j, 1, map[i][j]);
				visit[i][j]=false;
			}
		}
		System.out.println(max);

	}

	public static void dfs(int r, int c, int cnt, int sum) {
		if (cnt == 4) {

			max = Math.max(sum, max);
			return;
		}

		for (int d = 0; d < 4; d++) {
			int dr = r + delta[d][0];
			int dc = c + delta[d][1];

			if (dr < 0 || dc < 0 || dr >= n || dc >= m)
				continue;

			if (!visit[dr][dc]) {
				if (cnt == 2){
					visit[dr][dc] = true;
					dfs(r, c, cnt + 1, sum + map[dr][dc]);
					visit[dr][dc] = false;
				}

				visit[dr][dc] = true;
				dfs(dr, dc, cnt + 1, sum + map[dr][dc]);
				visit[dr][dc] = false;
			}
		}

	}
}
