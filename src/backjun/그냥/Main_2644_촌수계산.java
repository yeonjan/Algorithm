package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2644_촌수계산 {
	static int n, m, a, b;
	static int ans = Integer.MAX_VALUE;
	static int[][] adj;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		adj = new int[n][n];
		visited = new boolean[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken())-1;
		b = Integer.parseInt(st.nextToken())-1;

		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			adj[x][y] = 1;
			adj[y][x] = 1;
		}
		dfs(a, 0);

		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

	}

	public static void dfs(int idx, int dist) {
		if (idx == b) {
			ans = Math.min(ans, dist);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!visited[i] && adj[idx][i] == 1) {
				visited[i] = true;
				dfs(i, dist + 1);
			}
		}
	}
}
