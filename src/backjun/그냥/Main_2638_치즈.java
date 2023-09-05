package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_2638_치즈 {
    static int n;
    static int m;
    static int[][] map;
    static int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] countMap;
    static int hour;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        do {
            hour++;
            countMap = new int[n][m];
            bfs();
            melting();
        } while (!isEnd());

        System.out.println(hour);

    }

    public static void bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[n][m];
        visit[0][0] = true;
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int d = 0; d < 4; d++) {
                int dr = poll[0] + delta[d][0];
                int dc = poll[1] + delta[d][1];

                if (dr < 0 || dc < 0 || dr >= n || dc >= m) continue;

                if (map[dr][dc] == 0 && !visit[dr][dc]) {
                    visit[dr][dc] = true;
                    queue.offer(new int[]{dr, dc});
                }
                if (map[dr][dc] == 1) {
                    countMap[dr][dc]++;
                }

            }
        }
    }

    public static void melting() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (countMap[i][j] >= 2) map[i][j] = 0;
            }
        }
    }

    public static boolean isEnd() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) return false;
            }
        }
        return true;
    }
}
