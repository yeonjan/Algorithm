package ssafy.과제._0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2839_설탕배달 {
    static int N;
    static int[] DP = new int[5001];
    static int[] D = {-1, -1, -1, 1, -1, 1, 2, -1, 2, 3, 2, 3, 4};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            if (i <= 12) {
                DP[i] = D[i];
                continue;
            }
            DP[i] = Math.min(DP[i - 3], DP[i - 5])+1;
        }

        System.out.println(DP[N]);


    }
}
