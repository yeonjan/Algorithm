package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13422_도둑 {
    static int n, m, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            int[] prefixSum = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            prefixSum[0] = 0;
            for (int i = 1; i <= n; i++) {
                prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(st.nextToken());
            }

            int cnt = 0;

            for (int i = 0; i < n; i++) {
                int sum;
                if (i + m > n) sum = prefixSum[n] - prefixSum[i] + prefixSum[(i + m) % n];
                else sum = prefixSum[i + m] - prefixSum[i];

                if (sum < k) cnt++;
                if (n == m) break;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
