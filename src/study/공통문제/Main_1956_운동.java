package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1956_운동 {
    static int V, E, ans = Integer.MAX_VALUE;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new int[V][V];
        for (int i = 0; i < V; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            graph[a][b] = c;
        }
        setMinDist();
        comb(0, 0, new int[2]);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);


    }

    public static void setMinDist() {
        for (int i = 0; i < V; i++) {
            for (int s = 0; s < V; s++) {
                for (int e = 0; e < V; e++) {
                    if (graph[s][i] < Integer.MAX_VALUE && graph[i][e] < Integer.MAX_VALUE) {
                        graph[s][e] = Math.min(graph[s][e], graph[s][i] + graph[i][e]);
                    }
                }
            }
        }
    }

    public static void comb(int start, int cnt, int[] num) {
        if (cnt == 2) {
            int go = graph[num[0]][num[1]];
            int back = graph[num[1]][num[0]];
            if (go < Integer.MAX_VALUE && back < Integer.MAX_VALUE) {
                ans = Math.min(ans, go + back);
            }
            return;
        }

        for (int i = start; i < V; i++) {
            num[cnt] = i;
            comb(i + 1, cnt + 1, num);

        }
    }
}
