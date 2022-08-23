package ssafy.과제._0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7465_창용마을무리의개수_정연진 {
    static int T, N, M, ans;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            parent = new int[N + 1];
            visited = new boolean[N + 1];
            ans = 0;
            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                union(x, y);
            }
            for (int i = 1; i <= N; i++) {
                int rep = findSet(i);
                if (!visited[rep]) {
                    ans++;
                    visited[rep] = true;
                }
            }
            sb.append("#" + t + " " + ans + "\n");
        }
        System.out.println(sb);
    }

    public static void union(int x, int y) {
        int repX = findSet(x);
        int repY = findSet(y);
        parent[repY] = repX;
    }

    public static int findSet(int x) {
        if (x == parent[x]) return x;
        else return parent[x] = findSet(parent[x]);
    }
}
