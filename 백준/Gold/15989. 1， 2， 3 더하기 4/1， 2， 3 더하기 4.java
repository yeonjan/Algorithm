import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int T;
    static int SIZE = 10001;
    static int[][] dp = new int[SIZE][4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        setDp();

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(dp[num][1] + dp[num][2] + dp[num][3]);
        }

    }

    public static void setDp() {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = 1;
            }
        }

        for (int i = 4; i < SIZE; i++) {
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];

        }
    }


}