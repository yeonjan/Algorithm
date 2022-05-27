package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 파스칼의삼각형dp {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            sb = new StringBuilder();
            sb.append("#").append(test_case).append("\n");
            int n = Integer.parseInt(br.readLine());

            int[][] dp = new int[n + 1][n + 1];
            dp[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    sb.append(dp[i][j]).append(" ");
                }
                sb.append("\n");
            }

            System.out.println(sb);
        }
    }
}
