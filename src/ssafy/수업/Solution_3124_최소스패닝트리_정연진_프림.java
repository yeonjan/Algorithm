package ssafy.수업;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

public class Solution_3124_최소스패닝트리_정연진_프림 {
    static int T, V, E;
    static List<int[]>[] adj;
    static boolean[] visited;

    static class Node {
        int num;
        int w;

        public Node(int num, int w) {
            this.num = num;
            this.w = w;
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
            visited = new boolean[V];
            adj = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new ArrayList<>();
            }

            E = Integer.parseInt(st.nextToken());
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                adj[a - 1].add(new int[]{b - 1, c});
                adj[b - 1].add(new int[]{a - 1, c});
            }
            long mst = getMst();
            sb.append("#" + t + " " + mst + "\n");
        }
        System.out.println(sb);
    }

    public static long getMst() {
        Long result = 0L;
        int cnt=0;

        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });
        queue.offer(new Node(0, 0));

        while (cnt<V) {

            Node minV = queue.poll();
            if (!visited[minV.num]) {
                cnt++;
                visited[minV.num] = true;
                result += minV.w;
                //queue.clear();

                for (int[] e : adj[minV.num]) {
                    int to = e[0];
                    int weight = e[1];

                    if (!visited[to]) {
                        queue.offer(new Node(to, weight));
                    }

                }

            }

        }

        return result;
    }
}

