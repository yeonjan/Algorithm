package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_1916_최소비용구하기 {
    static ArrayList<int[]>[] adj;
    static int[] dist;
    static int n, m, a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        adj = new ArrayList[n + 1];
        dist = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);
            adj[s].add(new int[]{e, w});
        }

        String[] input = br.readLine().split(" ");
        a = Integer.parseInt(input[0]);
        b = Integer.parseInt(input[1]);

        dijkstra();
        System.out.println(dist[b]);

    }

    public static void dijkstra() {
        //목적지, 비용
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{a, 0});
        dist[a] = 0;

        while (!pq.isEmpty()) {
            int[] minEdge = pq.poll();

            int city = minEdge[0];
            int cost = minEdge[1];
            if (dist[city] < cost) continue; // 이미 처리 완료

            dist[city] = cost;

            for (int[] next : adj[city]) {
                int nextCity = next[0];
                int nextCost = next[1];
                if (dist[nextCity] > nextCost + dist[city]) {
                    pq.add(new int[]{nextCity, dist[nextCity]});
                }
            }

        }
    }
}
