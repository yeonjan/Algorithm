package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2473_세용액 {
    static long ans = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        long[] sol = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sol[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sol);

        END:
        for (int i = 0; i < n; i++) {
            int l = i + 1;
            int r = n - 1;

            while (l < r) {
                long sum = sol[i] + sol[l] + sol[r];
                if (ans > Math.abs(sum)) {
                    ans = Math.abs(sum);
                    sb.setLength(0);
                    sb.append(sol[i]).append(" ").append(sol[l]).append(" ").append(sol[r]);
                }

                if (sum < 0) l++;
                else if (sum > 0) r--;
                else {
                    sb.append(sol[i]).append(" ").append(sol[l]).append(" ").append(sol[r]);
                    break END;
                }
            }
        }
        System.out.println(sb);
    }
}
