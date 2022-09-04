package study.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1149_RGB구하기 {
    static int N;
    static int[][] dp, input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dp = new int[N][3];
        input = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) {
            dp[0][i] = input[0][i];
        }

        for (int i=1;i<N;i++){
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + input[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + input[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + input[i][2];
        }

        Arrays.sort(dp[N - 1]);
        System.out.println(dp[N - 1][0]);


    }
}
