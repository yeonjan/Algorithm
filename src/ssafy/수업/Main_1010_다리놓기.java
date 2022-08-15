package ssafy.수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1010_다리놓기 {
    static int T, N, M;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            dp = new int[N + 1][M + 1];
            DP();
            sb.append(dp[N][M]).append("\n");
        }
        System.out.println(sb);
    }

    public static void DP() {

        for (int i = 1; i <= M; i++) {
            dp[1][i] = i;
        }
        for (int n = 2; n <= N; n++) {
            for (int m = 1; m <= M; m++) {
                dp[n][m] = dp[n - 1][m - 1] + dp[n][m - 1];
            }
        }
    }

}
