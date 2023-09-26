package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_1261_알고스팟 {
    static int M;
    static int N;
    static int[][] map;
    static int[][] countBrokenWall;
    static int[][] delta = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        countBrokenWall = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
                countBrokenWall[i][j] = Integer.MAX_VALUE;
            }
        }
        bfs();
        System.out.println(countBrokenWall[N - 1][M - 1]);
    }

    public static void bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 0});
        countBrokenWall[0][0] = 0;


        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int r = poll[0];
            int c = poll[1];
            int count = poll[2];

            for (int d = 0; d < 4; d++) {
                int dr = r + delta[d][0];
                int dc = c + delta[d][1];

                if (dr < 0 || dc < 0 || dr >= N || dc >= M) continue;
                int nextCount=count;
                if (map[dr][dc] == 1) {
                    nextCount += 1;
                }
                if (countBrokenWall[dr][dc] > nextCount) {
                    countBrokenWall[dr][dc] = nextCount;
                    queue.offer(new int[]{dr, dc, nextCount});
                }
            }
        }


    }
}
