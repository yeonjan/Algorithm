package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최장경로 {
    static int result;
    static int n;
    static int m;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= t; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }

            result = 0;
            for(int i=1;i<=n;i++) {
                visit = new boolean[n + 1];
                dfs(1, i);
            }
            System.out.println("#" + test_case + " " + result);

        }
    }

    public static void dfs(int depth, int from) {
        result = Math.max(depth, result);
        visit[from] = true;
        for (int to : graph[from]) {
            if (!visit[to]) {
                dfs(depth + 1, to);
                visit[to] = false;
            }
        }

    }
}