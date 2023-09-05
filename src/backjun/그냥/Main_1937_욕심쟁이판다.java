package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1937_욕심쟁이판다 {

    static int n;
    static int ans = 0;
    static int[][] map;
    static int[][] dist;
    static int[][] delta = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(i, j));

            }
        }
        System.out.println(ans);


    }

    public static int dfs(int r, int c) {
        if (dist[r][c] != 0) {
            return dist[r][c];
        }
        int cnt = 0;
        for (int d = 0; d < 4; d++) {
            int dr = r + delta[d][0];
            int dc = c + delta[d][1];
            if (dr < 0 || dc < 0 || dr >= n || dc >= n) continue;

            if (map[dr][dc] > map[r][c]) {
                cnt = Math.max(dfs(dr, dc), cnt);
            }

        }
        dist[r][c] = cnt + 1;
        return dist[r][c];

    }
}