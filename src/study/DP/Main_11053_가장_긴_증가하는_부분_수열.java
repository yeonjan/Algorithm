package study.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11053_가장_긴_증가하는_부분_수열 {
    static int N, ans = 1;
    static int[] A, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());
        A = new int[N];
        dp = new int[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i]);
        }


        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            int cur = A[i];
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (cur > A[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            ans = Math.max(dp[i], ans);
        }
        System.out.println(ans);
    }
}
