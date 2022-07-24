package backjun.알고리즘기초.다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        int answer;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = answer = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = arr[i];
            if (dp[i - 1] > 0) dp[i] += dp[i - 1];
            answer = Math.max(dp[i], answer);
        }

        System.out.println(answer);


    }
}
