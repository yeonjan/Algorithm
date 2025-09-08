import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void solve(int[][] map, int n, int m) {
        int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int day = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            day++;
            for (int i = 0; i < size; i++) {
                int[] tomato = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int dr = tomato[0] + delta[d][0];
                    int dc = tomato[1] + delta[d][1];

                    if (dr < 0 || dc < 0 || n <= dr || m <= dc) continue;

                    if (map[dr][dc] == 0) {
                        queue.offer(new int[]{dr, dc});
                        map[dr][dc] = 1;
                    }
                }
            }

        }

        if (isTomatoOk(n, m, map)) {
            System.out.println(day - 1);
        } else System.out.println(-1);
    }

    public static boolean isTomatoOk(int n, int m, int[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(map, n, m);

    }


}
