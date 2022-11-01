package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1167_트리의지름 {
    static List<int[]>[] adj;
    static int V, node = -1;
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        V = Integer.parseInt(br.readLine());
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= V; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int size = (st.countTokens() - 1) / 2;
            for (int j = 0; j < size; j++) {
                int to = Integer.parseInt(st.nextToken()) - 1;
                int dist = Integer.parseInt(st.nextToken());
                adj[v - 1].add(new int[]{to, dist});
            }
        }

        dfs(0, 0, new boolean[V]);
        dfs(0,node,new boolean[V]);


        System.out.println(ans);
    }

    public static void dfs(long sum, int from, boolean[] visited) {
        if (sum > ans) {
            ans = sum;
            node = from;
        }

        visited[from] = true;

        for (int[] v : adj[from]) {
            if (!visited[v[0]]) {
                dfs(sum + v[1], v[0], visited);
            }
        }


    }
}
