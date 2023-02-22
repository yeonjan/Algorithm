package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11054_가장긴바이토닉부분수열 {
	static int[] arr;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new int[n][2];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
				}
				if (arr[n - 1 - i] > arr[n - 1 - j]) {
					dp[n - 1 - i][1] = Math.max(dp[n - 1 - i][1], dp[n - 1 - j][1] + 1);
				}
			}
		}
		int ans = Arrays.stream(dp).map(a -> a[0] + a[1]).mapToInt(a -> a).max().getAsInt()+1;
		System.out.println(ans);

	}
}
