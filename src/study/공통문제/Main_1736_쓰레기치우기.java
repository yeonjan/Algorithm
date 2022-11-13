package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1736_쓰레기치우기 {
    static int N, M, ans;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int start = M - 1; start >= 0; start--) {
            int row = N - 1;
            boolean needRobot = false;
            for (int c = start; c >= 0; c--) {
                for (int r = row; r >= 0; r--) {
                    if (map[r][c] == 1 && !visited[r][c]) {
                        needRobot = true;
                        visited[r][c] = true;
                        row = r;
                    }
                }
            }
            if (needRobot) ans++;
        }

        System.out.println(ans);
    }
}
