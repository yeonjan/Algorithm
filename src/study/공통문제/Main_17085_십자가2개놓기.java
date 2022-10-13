package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17085_십자가2개놓기 {
    static int n, m, ans;
    static String[][] map;
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new String[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split("");
        }

        comb(0, 1);
        System.out.println(ans);

    }

    public static void comb(int cnt, int sum) {
        if (cnt == 2) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (map[i][j].equals("#") && !visited[i][j]) {
                    int s = canSelect(i, j);
                    while (s >= 0) {
                        setVisited(i, j, s, true);
                        comb(cnt + 1, sum * (1 + s * 4));
                        setVisited(i, j, s, false);
                        s--;

                    }
                }
            }
        }

    }

    public static int canSelect(int i, int j) {
        int step = 0;
        FIND:
        while (true) {
            for (int d = 0; d < 4; d++) {
                int dr = i + delta[d][0] * (step + 1);
                int dc = j + delta[d][1] * (step + 1);
                if (dr < 0 || dc < 0 || dr >= n || dc >= m || map[dr][dc].equals(".") || visited[dr][dc]) break FIND;
            }
            step++;
        }
        return step;
    }

    public static void setVisited(int i, int j, int step, boolean TF) {
        visited[i][j] = TF;
        for (int s = 1; s <= step; s++) {
            for (int d = 0; d < 4; d++) {
                int dr = i + delta[d][0] * s;
                int dc = j + delta[d][1] * s;
                visited[dr][dc] = TF;
            }
        }
    }

}
