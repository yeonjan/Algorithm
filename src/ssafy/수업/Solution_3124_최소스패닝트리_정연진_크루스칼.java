package ssafy.수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_3124_최소스패닝트리_정연진_크루스칼 {
    static int T, V, E;
    static long ans;
    static int[] parent;
    static Queue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
        @Override
        public int compare(Edge o1, Edge o2) {
            return Integer.compare(o1.weight, o2.weight);
        }
    });

    static class Edge {
        int v1, v2, weight;

        public Edge(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            ans = 0;
            parent = new int[V];
            for (int i = 0; i < V; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                pq.offer(new Edge(a-1, b-1, c));
            }

            while (!pq.isEmpty()) {
                Edge e = pq.poll();
                if (union(e.v1, e.v2)){
                    ans += e.weight;
                }
            }

            sb.append("#" + t + " " + ans + "\n");
        }
        System.out.println(sb.toString());
    }

    public static boolean union(int x, int y) {
        int repX = findSet(x);
        int repY = findSet(y);
        if (repX == repY) return false;
        else {
            parent[repY] = repX;
            return true;
        }

    }

    public static int findSet(int x) {
        if (x == parent[x]) return x;
        else return parent[x] = findSet(parent[x]);
    }
}

