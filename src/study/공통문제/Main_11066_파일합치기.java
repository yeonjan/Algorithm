package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11066_파일합치기 {
    static int T, k, ans = Integer.MAX_VALUE;
    static int[] pSum;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            k = Integer.parseInt(br.readLine());
            dp = new int[k + 1][k + 1];
            pSum = new int[k + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= k; i++) {
                pSum[i] = Integer.parseInt(st.nextToken()) + pSum[i - 1];
            }

            ans = dp(1, k);
            System.out.println(ans);
        }
    }

    public static int dp(int a, int b) {
        if (a == b) return 0;
        if (dp[a][b] != 0) return dp[a][b];

        dp[a][b] = Integer.MAX_VALUE;
        for (int mid = a; mid < b; mid++) {
            dp[a][b] = Math.min(dp[a][b], dp(a, mid) + dp(mid + 1, b) + pSum[b] - pSum[a - 1]);
        }
        return dp[a][b];


    }
}
