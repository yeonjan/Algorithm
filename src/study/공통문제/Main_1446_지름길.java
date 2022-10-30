package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1446_지름길 {
    static int[][] adj, dist;
    static int n, d;

    static class Node {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        dist = new int[d + 1][d + 1];
        for (int i = 0; i <= d; i++) {
            for (int j = i + 1; j <= d; j++) {
                dist[i][j] = j - i;
            }
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            if (end > d) continue;
            dist[start][end] = Math.min(dist[start][end], value);
        }

        dijkstra();
        System.out.println(dist[0][d]);


    }

    public static void dijkstra() {
        boolean[] visited = new boolean[d + 1];
        int minNode = 0;

        for (int v = 0; v <= d; v++) {
            int minValue = Integer.MAX_VALUE;
            visited[minNode] = true;
            for (int i = 0; i <= d; i++) {
                if (visited[i]) continue;
                if (i > minNode) {
                    dist[0][i] = Math.min(dist[0][i], dist[0][minNode] + dist[minNode][i]);
                }

                if (minValue > dist[0][i]) {
                    minNode = i;
                    minValue = dist[0][i];
                }
            }
        }
    }
}
