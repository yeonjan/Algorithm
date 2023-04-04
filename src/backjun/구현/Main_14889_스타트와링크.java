package backjun.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크 {
	static int n;
	static int total = 0;
	static int min = Integer.MAX_VALUE;
	static int[][] s;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		s = new int[n][n];
		visit = new boolean[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				s[i][j] = Integer.parseInt(st.nextToken());
				total += s[i][j];
			}
		}
		dfs(0, 0, 0, total);
		System.out.println(min);
	}

	public static void dfs(int idx, int cnt, int start, int link) {
		if (cnt == n / 2) {
			int abs = Math.abs(start - link);
			min = Math.min(min, abs);
			return;
		}

		for (int i = idx; i < n; i++) {
			visit[i] = true;
			dfs(i + 1, cnt + 1, start + getAddSum(i, true), link - getAddSum(i, false));
			visit[i] = false;
		}
	}

	public static int getAddSum(int i, boolean isStartTeam) {
		int sum = 0;
		for (int j = 0; j < n; j++) {
			if (visit[j] == isStartTeam) {
				sum += s[i][j] + s[j][i];

			}
		}
		return sum;
	}
}
