package backjun.알고리즘기초.다이나믹프로그래밍1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 제곱수의_합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (i % Math.sqrt(i) == 0) {
                dp[i] = 1;
                continue;
            }

            dp[i] = i;
            for (int j = 1; j * j < i; j++) {
                //ex) i = 6
                //모든 조합 -> (1,5),(2,4),(3,3)
                //dp[i] = Math.min(dp[j] + dp[i - j], dp[i]);

                //i보다 작은 제곱값을 포함하는 조합만! -> (1*1,5),(2*2,2)
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }

        System.out.println(dp[n]);
    }
}
