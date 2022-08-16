package study.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1260_DFSBFS {
    static int N, M, V;
    static boolean[] visit;
    static int[] selected;
    static List<Integer>[] edge;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        visit = new boolean[N + 1];
        selected = new int[N];
        edge = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            edge[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edge[a].add(b);
            edge[b].add(a);
        }
        for (List<Integer> e : edge) {
            Collections.sort(e);
        }

        dfs(V, visit, 0);
        sb.append("\n");

        visit = new boolean[N + 1];
        bfs();
        sb.append("\n");

        System.out.println(sb.toString());


    }

    public static void dfs(int Node, boolean[] visit, int cnt) {
        sb.append(Node + " ");
        visit[Node] = true;
        for (int e : edge[Node]) {
            if (!visit[e]) {
                dfs(e, visit, cnt + 1);
            }
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(V);
        visit[V] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node + " ");
            for (int e : edge[node]) {
                if (!visit[e]) {
                    visit[e] = true;
                    queue.add(e);
                }
            }
        }

    }
}
