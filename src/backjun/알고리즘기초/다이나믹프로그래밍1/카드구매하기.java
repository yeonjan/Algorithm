package backjun.알고리즘기초.다이나믹프로그래밍1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카드구매하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] price = new int[n + 1];
        int[] dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = price[1];

        //처음 풀이
        for (int i = 2; i <= n; i++) {
            for (int k = 0; k <= i / 2; k++) {
                int temp = 0;

                if (k == 0) temp = price[i];
                else temp = dp[k] + dp[i - k];

                dp[i] = Math.max(temp, dp[i]);

            }
        }

        //수정 풀이 -> 시간차이 X 코드길이 단축 O
/*        for (int i = 2; i <= n; i++) {
            for (int k = 0; k <= i; k++) {
                dp[i] = Math.max(dp[k] + price[i - k], dp[i]);

            }
        }*/
        System.out.println(dp[n]);


    }
}
