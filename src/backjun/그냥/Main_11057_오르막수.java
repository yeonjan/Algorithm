package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11057_오르막수 {
    static int n;
    static long[][] dp;
    static int DIV = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new long[n + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        setDp();

        long ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += dp[n][i];
            ans %= 10007;

        }
        System.out.println(ans);


    }

    public static void setDp() {
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
                dp[i][j] %= DIV;
            }
        }
    }
}
