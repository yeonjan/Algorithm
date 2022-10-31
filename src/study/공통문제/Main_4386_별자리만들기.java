package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4386_별자리만들기 {

    static double ans;
    static int[] parent;
    static double[][] stars;

    static class Edge {
        int a, b;
        double cost;

        public Edge(int a, int b, double cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        int min = Math.min(rootA, rootB);
        parent[rootA] = min;
        parent[rootB] = min;

    }

    static int find(int a) {
        if (a == parent[a]) return a;
        else return parent[a] = find(parent[a]);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingDouble(o -> o.cost));

        int n = Integer.parseInt(br.readLine());
        parent = new int[n];
        stars = new double[n][2];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            st = new StringTokenizer(br.readLine());
            stars[i][0] = Double.parseDouble(st.nextToken());
            stars[i][1] = Double.parseDouble(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double cost = Math.sqrt(Math.pow(stars[i][0] - stars[j][0], 2) + Math.pow(stars[i][1] - stars[j][1], 2));
                pq.offer(new Edge(i, j, cost));

            }
        }

        while (!pq.isEmpty()) {
            Edge minEdge = pq.poll();

            int rootA = find(minEdge.a);
            int rootB = find(minEdge.b);
            if (rootA != rootB) {
                union(minEdge.a, minEdge.b);
                ans += minEdge.cost;
            }
        }
        for (int i = 0; i < n; i++) {
            find(i);
        }
        System.out.printf("%.2f", ans);
    }
}
