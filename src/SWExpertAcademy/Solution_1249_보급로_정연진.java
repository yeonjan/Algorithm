package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Solution_1249_보급로_정연진 {
    static int n;
    static int[][] map, weight;
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            weight = new int[n][n];

            for (int i = 0; i < n; i++) {
                String input = br.readLine();
                for (int j = 0; j < n; j++) {
                    map[i][j] = input.charAt(j) - '0';
                }
            }

            for (int i = 0; i < n; i++) {
                Arrays.fill(weight[i], Integer.MAX_VALUE);
            }

            weight[0][0] = 0;

            bfs();
            sb.append("#" + t + " " + weight[n - 1][n - 1]).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs() {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            for (int d = 0; d < 4; d++) {
                int dr = cur[0] + delta[d][0];
                int dc = cur[1] + delta[d][1];

                if (dr < 0 || dc < 0 || dr >= n || dc >= n) continue;

                if (weight[dr][dc] > weight[r][c] + map[dr][dc]) {
                    weight[dr][dc] = weight[r][c] + map[dr][dc];
                    queue.offer(new int[]{dr, dc});
                }
            }

        }

    }
}
