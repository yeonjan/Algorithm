package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9465_스티커 {
	static int T;
	static int n;
	static int[][] map;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[2][n];
			dp = new int[2][n];
			for (int i = 0; i < 2; i++) {
				String[] input = br.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(input[j]);
				}
			}

			dp[0][0] = map[0][0];
			dp[1][0] = map[1][0];
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < 2; j++) {
					//대각선
					int dr = (j + 1) % 2;
					int pre = i - 2 >= 0 ? Math.max(dp[dr][i - 1], dp[dr][i - 2]) : dp[dr][i - 1];
					dp[j][i] = pre + map[j][i];
				}
			}
			System.out.println(Math.max(dp[0][n-1],dp[1][n-1]));

		}

	}
}
