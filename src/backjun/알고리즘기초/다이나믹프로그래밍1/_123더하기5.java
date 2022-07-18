package backjun.알고리즘기초.다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _123더하기5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int D = 1000000009;
        int test = Integer.parseInt(br.readLine());
        long[][] dp = new long[100001][4];
        dp[1][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;

        for (int i = 4; i < 100001; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % D;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % D;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % D;
        }
        for (int t = 0; t < test; t++) {
            int n = Integer.parseInt(br.readLine());
            sb.append((dp[n][1] + dp[n][2] + dp[n][3]) % D).append("\n");
        }
        System.out.println(sb);
    }
}
