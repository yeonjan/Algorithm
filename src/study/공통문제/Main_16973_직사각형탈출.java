package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_16973_직사각형탈출 {
    static int[][] map, pSum, delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int n, m, h, w, ans = -1;
    static Point s, f;

    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        pSum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                pSum[i][j] = pSum[i - 1][j] + pSum[i][j - 1] - pSum[i - 1][j - 1] + map[i][j];
            }
        }

        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        s = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        f = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        bfs(s);
        System.out.println(ans);

    }

    public static void bfs(Point start) {
        LinkedList<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n + 1][m + 1];

        queue.offer(start);
        visited[start.r][start.c] = true;
        int dist = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            dist++;
            for (int s = 0; s < size; s++) {
                Point poll = queue.poll();
                if (poll.r == f.r && poll.c == f.c) {
                    queue.clear();
                    ans = dist;
                    return;
                }

                for (int d = 0; d < 4; d++) {
                    int dr = poll.r + delta[d][0];
                    int dc = poll.c + delta[d][1];

                    if (dr > 0 && dc > 0 && dr <= n && dc <= m && !visited[dr][dc]) {
                        visited[dr][dc] = true;
                        Point nP = new Point(dr, dc);
                        if (check(nP)) queue.offer(nP);
                    }
                }
            }

        }
    }

    public static boolean check(Point p) {
        if (p.r + h - 1 > n || p.c + w - 1 > m) return false;

        int sum = pSum[p.r + h - 1][p.c + w - 1] - pSum[p.r + h - 1][p.c - 1] - pSum[p.r - 1][p.c + w - 1] + pSum[p.r - 1][p.c - 1];
        if (sum > 0) return false;
        return true;
    }

}
