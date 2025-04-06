import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int MAX_VALUE = 4000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V, E;// 1~V 마을
        int ans = MAX_VALUE;
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        int[][] dist = new int[V + 1][V + 1];

        for (int i = 0; i <= V; i++) {
            Arrays.fill(dist[i], MAX_VALUE);
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = c;
        }


        for (int s = 1; s <= V; s++) {
            for (int e = 1; e <= V; e++) {
                for (int m = 1; m <= V; m++) {
                    dist[s][e] = Math.min(dist[s][e], dist[s][m] + dist[m][e]);
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            ans = Math.min(ans, dist[i][i]);
        }
        System.out.println(ans != MAX_VALUE ? ans : -1);


    }


}