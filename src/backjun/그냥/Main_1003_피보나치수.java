package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1003_피보나치수 {
	static int T;
	static int[][] dp = new int[41][2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		getAll();
		for (int i = 0; i < T; i++) {
			int input = Integer.parseInt(br.readLine());
			sb.append(dp[input][0] + " " + dp[input][1]).append("\n");
		}
		System.out.println(sb);

	}

	private static void getAll() {
		dp[0] = new int[] {1, 0};
		dp[1] = new int[] {0, 1};
		for (int i = 2; i < 41; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
			dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
		}
	}
}
