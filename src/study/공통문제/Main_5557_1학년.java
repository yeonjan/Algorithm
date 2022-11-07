package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5557_1학년 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        long[][] dp = new long[N][21];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][arr[0]] = 1;
        for (int i = 1; i < N - 1; i++) {
            for (int num = 0; num <= 20; num++) {
                int cur = arr[i];
                if (num - cur >= 0) dp[i][num] += dp[i - 1][num - cur];
                if (num + cur <= 20) dp[i][num] += dp[i - 1][num + cur];
            }
        }

        System.out.println(dp[N - 2][arr[N - 1]]);
    }
}
