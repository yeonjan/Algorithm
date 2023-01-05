package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3584_가장가까운공통조상 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int ans = 0;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] parent = new int[n + 1];
            int[] cnt = new int[n + 1];

            for (int i = 1; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                parent[b] = a;
            }
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            for (int i = 1; i < n; i++) {
                if (node1 != 0) cnt[node1]++;
                if (node2 != 0) cnt[node2]++;

                if (cnt[node1] == 2) {
                    ans = node1;
                    break;
                }
                if (cnt[node2] == 2) {
                    ans = node2;
                    break;
                }

                node1 = parent[node1];
                node2 = parent[node2];


            }

            sb.append(ans + "\n");

        }
        System.out.println(sb.toString());


    }
}
