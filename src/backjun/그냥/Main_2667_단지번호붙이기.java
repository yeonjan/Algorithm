package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main_2667_단지번호붙이기 {
	static int n;
	static int total = 0;
	static int cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> list = new ArrayList<>();
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}

		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					cnt = 0;
					dfs(i, j);
					total++;
					list.add(cnt);
				}
			}
		}

		sb.append(total).append("\n");
		list.sort(Comparator.naturalOrder());

		for (Integer integer : list) {
			sb.append(integer).append("\n");
		}
		System.out.println(sb);

	}

	public static void dfs(int r, int c) {
		cnt++;
		visited[r][c] = true;

		for (int d = 0; d < 4; d++) {
			int dr = r + delta[d][0];
			int dc = c + delta[d][1];

			if (dr < 0 || dc < 0 || dr >= n || dc >= n)
				continue;

			if (map[dr][dc] == 1 && !visited[dr][dc]) {
				dfs(dr, dc);
			}
		}
	}
}
