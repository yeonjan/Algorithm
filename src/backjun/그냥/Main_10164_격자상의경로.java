package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10164_격자상의경로 {
    static int[][] dp;
    static int n, m, o;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        o = Integer.parseInt(st.nextToken());

        dp = new int[n][m];
        int oy = (o - 1) / m;
        int ox = (o - 1) % m;

        setDp();
        int ans = o == 0 ? dp[n - 1][m - 1] : dp[oy][ox] * dp[n - 1 - oy][m - 1 - ox];
//        int ans = o == 0 ? f(n - 1, m - 1) : f(oy, ox) * f(n - 1 - oy, m - 1 - ox);

        System.out.println(ans);
    }

    public static void setDp() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] =1;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

            }
        }
    }
//    public static int f(int y, int x) {
//        if (y == 0 || x == 0) return 1;
//        if (dp[y][x] != 0) return dp[y][x];
//
//        dp[y][x] = f(y - 1, x) + f(y, x - 1);
//        return dp[y][x];
//
//
//    }
}
