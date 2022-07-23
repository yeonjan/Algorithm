package backjun.알고리즘기초.다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장_긴_증가하는_수열 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int answer = 0;
        int idx = 0;
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[][] dp = new int[n][2];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            for (int j = 0; j < n; j++) {
                if (A[i] > A[j] && dp[j][0] + 1 > dp[i][0]) {
                    dp[i][0] = dp[j][0] + 1;
                    dp[i][1] = j;
                }
            }
            if (dp[i][0] > answer) {
                answer = dp[i][0];
                idx = i;
            }
        }

        for (int i = 0; i < answer; i++) {
            sb.insert(0, " ").insert(0, A[idx]);
            idx = dp[idx][1];
        }
        System.out.println(answer);
        System.out.println(sb);


    }
}
