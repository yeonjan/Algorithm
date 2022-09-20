package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1238_파티pq {
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
            if (i == x) continue;
            ans = Math.max(dist[i][x] + dist[x][i], ans);
        }
        System.out.println(ans);

    }

    public static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.offer(new int[]{start, 0});
        dist[start][start] = 0;


        while (!pq.isEmpty()) {
            //방문하지 않은 노드 중 최단 거리가 가장 짧은 노드 선택
            int[] min = pq.poll();
            int next = min[0];

            //해당 노드를 거쳐 다른 노드로 가능 비용 계산
            for (int[] adj : adjList[next]) {
                int to = adj[0];
                int time = adj[1];
                if (dist[start][to] > dist[start][next] + time) {
                    dist[start][to] = dist[start][next] + time;
                    pq.offer(adj);
                }
            }
        }

    }
}
