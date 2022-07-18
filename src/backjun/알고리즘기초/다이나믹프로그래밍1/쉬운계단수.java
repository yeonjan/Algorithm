package backjun.알고리즘기초.다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쉬운계단수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mod = 1000000000;
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[101][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int end = 0; end < 10; end++) {
                dp[i][end]=0;
                if (end > 0) dp[i][end] += dp[i - 1][end - 1];
                if (end < 9) dp[i][end] += dp[i - 1][end + 1];
                dp[i][end] %= mod;
            }
        }

        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[n][i];
            result%=mod;
        }
        System.out.println(result);
    }
}
