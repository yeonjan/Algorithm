package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_4485_녹색옷입은애가젤다지 {

    static int n;
    static int[][] map, weight;
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = 0;
        while (true) {
            t++;
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            weight = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    weight[i][j] = Integer.MAX_VALUE;
                }
            }
            if (n == 0) break;
            bfs();

            sb.append("Problem " + t + ": " + weight[n - 1][n - 1]).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs() {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, map[0][0]});
        weight[0][0] = map[0][0];

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int d = 0; d < 4; d++) {
                int dr = poll[0] + delta[d][0];
                int dc = poll[1] + delta[d][1];
                int w = poll[2];
                if (dr < 0 || dc < 0 || dr >= n || dc >= n) continue;

                if (weight[dr][dc] > weight[poll[0]][poll[1]] + map[dr][dc]) {
                    weight[dr][dc] = weight[poll[0]][poll[1]] + map[dr][dc];
                    queue.offer(new int[]{dr, dc, weight[dr][dc]});
                }
            }
        }
    }
}
