package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_3687_성냥개비 {
    static int[] match = {0, 2, 5, 5, 4, 5, 6, 3, 7, 6};
    static long[] min = new long[101];
    static String[] max = new String[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Arrays.fill(min, Long.MAX_VALUE);
        for (int i = 0; i <= 9; i++) {
            int cnt = match[i];
            min[cnt] = Math.min(min[cnt], i);
        }
        max[2] = "1";
        max[3] = "7";
        for (int i = 4; i <= 100; i++) {
            //max
            max[i] = max[i - 2] +""+ 1;
            //min
            for (int j = 2; j <= i - 2; j++) {
                long temp;
                if (i - j == 6) {
                    temp = Long.parseLong(min[j] + "0");
                }
                else temp = Long.parseLong(min[j] + "" + min[i - j]);
                min[i] = Math.min(min[i], temp);
            }
        }

        for (int i = 0; i < n; i++) {
            int cnt = Integer.parseInt(br.readLine());
            sb.append(min[cnt]).append(" ").append(max[cnt]).append("\n");
        }

        System.out.println(sb);

    }
}
