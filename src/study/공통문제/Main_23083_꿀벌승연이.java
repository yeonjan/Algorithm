package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_23083_꿀벌승연이 {
    static boolean[][] isHole;
    static long[][] dp;
    static int n, m;
    static int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        isHole = new boolean[n + 1][m + 1];
        dp = new long[n + 2][m + 2];

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            isHole[x][y] = true;
        }
        //dp 경로 계산
        dp[0][0] = 1;
        for (int c = 1; c <= m; c++) {
            for (int r = 1; r <= n; r++) {
                if (isHole[r][c]) continue;

                if (c % 2 != 0)
                    dp[r][c] += (dp[r - 1][c] + dp[r][c - 1] + dp[r - 1][c - 1]) % MOD;
                else
                    dp[r][c] += (dp[r - 1][c] + dp[r][c - 1] + dp[r + 1][c - 1]) % MOD;

            }
        }

        System.out.println(dp[n][m]);

    }


}
