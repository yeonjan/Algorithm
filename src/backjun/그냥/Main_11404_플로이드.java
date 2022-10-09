package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11404_플로이드 {
    static int INF = 10000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] adj = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                adj[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a][b] = Math.min(adj[a][b], c);
        }

        //최소 비용 구하기
        for (int num = 1; num <= n; num++) {
            for (int i = 1; i <= n; i++) {
                if (i == num) continue;
                for (int j = 1; j <= n; j++) {
                    if (i == j) continue;
                    adj[i][j] = Math.min(adj[i][j], adj[i][num] + adj[num][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (adj[i][j] == INF) adj[i][j] = 0;
                sb.append(adj[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);


    }
}
