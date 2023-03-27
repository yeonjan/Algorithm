package backjun.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14501_퇴사 {
	static int n;
	static int[] dp;
	static int[][] input;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];
		input = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = n - 1; i >= 0; i--) {
			int restDay = n - i ;
			int nextDay = input[i][0];
			int price = input[i][1];
			if (restDay < nextDay) {
				dp[i] = dp[i + 1];
				continue;
			}

			dp[i] = Math.max(price + dp[i + nextDay], dp[i + 1]);
		}

		System.out.println(dp[0]);

	}
}
