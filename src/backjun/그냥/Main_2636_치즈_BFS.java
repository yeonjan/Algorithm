package backjun.그냥;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_2636_치즈_BFS {
    static int w, h, cnt;
    static int[][] map, map2, delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean[][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        map = new int[h][w];
        map2 = new int[h][w];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        int last = 0;

        while (true) {
            count();
            if (cnt == 0) break;

            day++;
            last = cnt;
            oneDayLater();

        }

        System.out.println(day);
        System.out.println(last);

    }

    public static void oneDayLater() {
        for (int i = 0; i < h; i++) {
            map2[i] = map[i].clone();
        }
        visited = new boolean[h][w];
        LinkedList<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int d = 0; d < 4; d++) {
                int dr = poll[0] + delta[d][0];
                int dc = poll[1] + delta[d][1];

                if (check(dr, dc)) continue;

                if (!visited[dr][dc]) {
                    if (map[dr][dc] == 0) {
                        queue.offer(new int[]{dr, dc});
                        visited[dr][dc] = true;
                    } else {
                        map2[dr][dc] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < h; i++) {
            map[i] = map2[i].clone();
        }

    }
    public static void count() {
        cnt = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 1) {
                    cnt++;
                }
            }
        }
    }

    public static boolean check(int dr, int dc) {
        return dr < 0 || dc < 0 || dr >= h || dc >= w;
    }


}
