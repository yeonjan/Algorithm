import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n, m;
    static int MAX_VALUE = 10000000;
    static int[][] delta = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int[][] map;
    static int[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new int[n][m][2];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
                visited[i][j][0] = MAX_VALUE;
                visited[i][j][1] = MAX_VALUE;
            }
        }
        bfs();

        int ans = Math.min(visited[n - 1][m - 1][1], visited[n - 1][m - 1][0]);
        System.out.println(ans == MAX_VALUE ? -1 : ans);


    }

    public static void bfs() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> visited[a[0]][a[1]][a[2]]));
        pq.offer(new int[]{0, 0, 0});
        visited[0][0][0] = 1;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int r = poll[0];
            int c = poll[1];
            int wall = poll[2];
            for (int d = 0; d < 4; d++) {
                int dr = r + delta[d][0];
                int dc = c + delta[d][1];
                if (dr < 0 || dc < 0 || dr >= n || dc >= m) continue;

                if (wall == 1 && map[dr][dc] == 1) continue;


                if (wall == 1 && map[dr][dc] == 0 || wall == 0 && map[dr][dc] == 1) {
                    if (visited[dr][dc][1] > visited[r][c][wall] + 1) {
                        visited[dr][dc][1] = visited[r][c][wall] + 1;
                        pq.offer(new int[]{dr, dc, 1});
                    }
                } else if (wall == 0 && map[dr][dc] == 0) {
                    if (visited[dr][dc][0] > visited[r][c][wall] + 1) {
                        visited[dr][dc][0] = visited[r][c][wall] + 1;
                        pq.offer(new int[]{dr, dc, 0});
                    }
                }

            }
        }


    }


}