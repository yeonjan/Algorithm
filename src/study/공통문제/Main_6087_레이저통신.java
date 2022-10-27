package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_6087_레이저통신 {
    static int w, h;
    static String[][] map;
    static int[][] cnt, delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean[][][] visit;

    static class Point {
        int r, c, cnt, inputDirection;

        public Point(int r, int c, int cnt, int inputDirection) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.inputDirection = inputDirection;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new String[h][w];
        cnt = new int[h][w];
        visit = new boolean[h][w][10000];
        for (int i = 0; i < h; i++) {
            map[i] = br.readLine().split("");
            Arrays.fill(cnt[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j].equals("C")) {
                    bfs(i, j);
                    break;
                }

            }
        }

        System.out.println("A");
    }

    public static void bfs(int r, int c) {
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return Integer.compare(o1.cnt, o2.cnt);
            }
        });

        for (int i = 0; i < 4; i++) {
            int dr = r + delta[i][0];
            int dc = c + delta[i][1];
            if (check(dr, dc) && map[dr][dc].equals(".")) {
                pq.add(new Point(dr, dc, 0, i));
            }
        }
        while (!pq.isEmpty()) {
            Point poll = pq.poll();
            if (map[poll.r][poll.c].equals("C")) {
                System.out.println(poll.cnt);
                break;
            }
            for (int i = 1; i <= 3; i += 2) {
                int d = (poll.inputDirection + i) % 4;
                int dr = poll.r + delta[d][0];
                int dc = poll.c + delta[d][1];
                if (check(dr, dc) && map[dr][dc].equals(".") && !visit[dr][dc][poll.cnt + 1] && cnt[dr][dc] > poll.cnt + 1) {
                    pq.add(new Point(dr, dc, poll.cnt + 1, d));
                    visit[dr][dc][poll.cnt + 1] = true;
                }
            }
        }

    }

    public static boolean check(int dr, int dc) {
        return dr >= 0 && dc >= 0 && dr < h && dc < w;
    }

}
