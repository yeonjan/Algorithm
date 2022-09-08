package study.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1463_1로만들기 {
    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];

        if (n >= 2) dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            if (i % 3 == 0) min = Math.min(dp[i / 3], min);
            if (i % 2 == 0) min = Math.min(dp[i / 2], min);
            min = Math.min(dp[i - 1], min);

            dp[i] = min + 1;
        }
        System.out.println(dp[n]);

    }
}
