package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_14466_소가길을건너간이유6 {
    static int n, k, r;
    static long ans;
    static int[][] map, delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean[][] visited;
    static List<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        adj = new ArrayList[n * n];
        ans = k*(k-1);

        for (int i = 0; i < n * n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;

            int a = r1 * n + c1;
            int b = r2 * n + c2;
            adj[a].add(b);
            adj[b].add(a);
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    visited = new boolean[n][n];
                    dfs(i, j);
                }

            }

        }

        System.out.println(ans/2);

    }

    public static void dfs(int r, int c) {
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int dr = r + delta[i][0];
            int dc = c + delta[i][1];
            if (dr < 0 || dc < 0 || dr >= n || dc >= n) continue;

            if (!visited[dr][dc] && !adj[r * n + c].contains(dr * n + dc)) {
                if (map[dr][dc] == 1) ans--;
                dfs(dr, dc);
            }
        }
    }

}
