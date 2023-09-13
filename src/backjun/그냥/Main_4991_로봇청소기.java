package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_4991_로봇청소기 {
    static int w;
    static int h;
    static String[][] map;
    static int[][] dustMap;
    static int dustCnt;
    static int[][] delta = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        do {
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                break;
            }
            map = new String[h][w];
            dustMap = new int[h][w];
            ans = Integer.MAX_VALUE;
            int[] start = new int[2];
            int dustNum = 0;
            dustCnt = 0;
            for (int i = 0; i < h; i++) {
                String[] input = br.readLine().split("");
                for (int j = 0; j < w; j++) {
                    map[i][j] = input[j];
                    if (map[i][j].equals("*")) {
                        dustMap[i][j] = (int) Math.pow(2, dustNum++);
                        dustCnt++;
                    } else if (map[i][j].equals("o")) {
                        start = new int[]{i, j};
                    }
                }
            }
            bfs(start);
            sb.append(ans == Integer.MAX_VALUE ? -1 : ans).append("\n");


        } while ((st = new StringTokenizer(br.readLine())).hasMoreTokens());
        System.out.println(sb);
    }

    public static void bfs(int[] start) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int maxCnt = (int) Math.pow(2, dustCnt);
        int[][][] visited = new int[maxCnt][h][w];
        visited[0][start[0]][start[1]] = 1;
        queue.offer(new int[]{start[0], start[1], 0, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int bit = poll[2];
            int cnt = poll[3];
            if (bit == maxCnt - 1) {
                ans = Math.min(ans, cnt);
                continue;
            }
            for (int d = 0; d < 4; d++) {
                int dy = poll[0] + delta[d][0];
                int dx = poll[1] + delta[d][1];


                //영역 밖일때
                if (dx < 0 || dy < 0 || dx >= w || dy >= h) {
                    continue;
                }
                //벽일때
                if (map[dy][dx].equals("x")) {
                    continue;
                }
                if (visited[bit][dy][dx] == 0) {
                    visited[bit][dy][dx] = cnt + 1;
                    if (map[dy][dx].equals("*")) {
                        int nextBit = bit | dustMap[dy][dx];
                        visited[nextBit][dy][dx] = cnt + 1;
                        queue.offer(new int[]{dy, dx, nextBit, cnt + 1});
                    } else {
                        queue.offer(new int[]{dy, dx, bit, cnt + 1});
                    }

                }
            }

        }

    }
}
