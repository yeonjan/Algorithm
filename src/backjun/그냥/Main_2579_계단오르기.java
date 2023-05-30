package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2579_계단오르기 {
	static int n;
	static int[] step;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		step = new int[n+1];
		dp = new int[2][n+1];
		for (int i = 1; i <= n; i++) {
			step[i] = Integer.parseInt(br.readLine());
		}

		dp[0][1] = step[1];

		for (int i = 1; i <= n; i++) {
			if (i - 2 >= 0) {
				dp[0][i] = Math.max(dp[0][i - 2], dp[1][i - 2]) + step[i];
			}
			dp[1][i] = dp[0][i - 1] + step[i];
		}
		System.out.println(Math.max(dp[0][n],dp[1][n]));

	}
}
