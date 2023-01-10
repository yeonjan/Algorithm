package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1405_미친로봇 {
    static int n;
    static double ans;
    static boolean[][] visited;
    static double[] percent = new double[4];
    static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; //동서남북

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 4; i++) {
            percent[i] = Double.parseDouble(st.nextToken()) / 100;
        }

        visited = new boolean[2 * n + 1][2 * n + 1];
        visited[n][n] = true;

        dfs(0, new int[]{n, n}, 1);

        System.out.println(ans);

    }

    public static void dfs(int cnt, int[] pos, double p) {
        if (cnt == n) {
            ans += p;
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (percent[i] == 0) continue;
            int dr = pos[0] + delta[i][0];
            int dc = pos[1] + delta[i][1];
            if (dr < 0 || dc < 0 || dr > 2 * n || dc > 2 * n) continue;

            if (!visited[dr][dc]) {
                visited[dr][dc] = true;
                dfs(cnt + 1, new int[]{dr, dc}, percent[i] * p);
                visited[dr][dc] = false;
            }
        }
    }
}
