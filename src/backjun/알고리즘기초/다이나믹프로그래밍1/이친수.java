package backjun.알고리즘기초.다이나믹프로그래밍1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이친수 {
    public static void main(String[] args) throws IOException {

        //1차원 배열 선언 후 dp[i]=dp[i-1]+dp[i-2]도 성립
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][2];

        dp[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
        }

        System.out.println(dp[n][0]+dp[n][1]);
    }
}