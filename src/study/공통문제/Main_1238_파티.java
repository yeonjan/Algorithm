package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1238_파티 {
    static int n, m, x, ans;
    static List<int[]>[] adjList;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[n + 1];
        dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            adjList[a].add(new int[]{b, t});
        }

        for (int i = 1; i <= n; i++) {
            dijkstra(i);
        }
        for (int i = 1; i <= n; i++) {
            if (i==x) continue;
            ans = Math.max(dist[i][x] + dist[x][i], ans);
        }
        System.out.println(ans);

    }

    public static void dijkstra(int start) {
        boolean[] visited = new boolean[n + 1];
        visited[start] = true;

        for (int[] adj : adjList[start]) {
            int to = adj[0];
            int time = adj[1];
            dist[start][to] = time;
        }

        for (int cnt = 0; cnt < n - 1; cnt++) {
            //방문하지 않은 노드 중 최단 거리가 가장 짧은 노드 선택
            int min = Integer.MAX_VALUE;
            int next = -1;
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && min >= dist[start][i]) {
                    next = i;
                    min = dist[start][i];
                }
            }
            visited[next] = true;

            //해당 노드를 거쳐 다른 노드로 가능 비용 계산& 최단 거리 테이블 갱신
            for (int[] adj : adjList[next]) {
                int to = adj[0];
                int time = adj[1];
                dist[start][to] = Math.min(dist[start][to], dist[start][next] + time);
            }
        }

    }
}
