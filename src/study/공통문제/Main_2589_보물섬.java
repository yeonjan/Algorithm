package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_2589_보물섬 {
    static int n,m,ans;
    static char[][]map;
    static boolean[][]visitedOrigin;
    static int[][]delta= {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

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

        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());
        map= new char[n][m];
        visitedOrigin= new boolean[n][m];
        for (int i = 0; i <n; i++) {
            String input = br.readLine();
            for (int j = 0; j <m; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'W') {
                    visitedOrigin[i][j] = true;
                }
            }
        }
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <m; j++) {
                if (map[i][j] == 'L') {
                    bfs(new Point(i, j));
                }
            }
        }

        System.out.println(ans);
    }

    public static void bfs(Point start) {
        //방문배열 초기화
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i <n; i++) {
            visited[i] =visitedOrigin[i].clone();
        }
        int dist = 0;
        //큐 선언
        LinkedList<Point> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.r][start.c] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            ans= Math.max(ans, dist++);

            for (int s = 0; s < size; s++) {
                Point poll = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int r = poll.r +delta[i][0];
                    int c = poll.c +delta[i][1];
                    if (r >= 0 && c >= 0 && r <n&& c <m&& !visited[r][c]) {
                        queue.offer(new Point(r, c));
                        visited[r][c] = true;
                    }
                }
            }

        }
    }
}