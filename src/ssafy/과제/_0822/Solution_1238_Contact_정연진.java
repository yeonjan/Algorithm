package ssafy.과제._0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1238_Contact_정연진 {
    static boolean[][] adj;
    static boolean[] visited;
    static int L, S, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
            adj = new boolean[101][101];
            visited = new boolean[101];
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < L / 2; i++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj[a][b] = true;
            }

            bfs();
            sb.append("#" + t + " " + ans + "\n");
        }
        System.out.println(sb);
    }

    public static void bfs() {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(S);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans = 0;
            for (int i = 0; i < size; i++) {
                Integer cur = queue.poll();
                ans = Math.max(cur, ans);
                for (int j = 1; j < 101; j++) {
                    if (adj[cur][j] && !visited[j]) {
                        visited[j] = true;
                        queue.offer(j);
                    }
                }
            }
        }
    }
}
