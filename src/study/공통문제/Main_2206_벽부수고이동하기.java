package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2206_벽부수고이동하기 {
    static int N, M;
    static int[][] map, delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][][] minDist;

    static class Pos {
        int r, c, breakWall, dist;

        public Pos(int r, int c, int breakWall, int dist) {
            this.r = r;
            this.c = c;
            this.breakWall = breakWall;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        minDist = new int[2][N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
                minDist[0][i][j] = Integer.MAX_VALUE;
                minDist[1][i][j] = Integer.MAX_VALUE;
            }
        }

        bfs();
        int ans = Math.min(minDist[0][N - 1][M - 1], minDist[1][N - 1][M - 1]);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    public static void bfs() {
        PriorityQueue<Pos> pq = new PriorityQueue<>((Comparator.comparingInt(o -> o.dist)));
        pq.offer(new Pos(0, 0, 0, 1));
        minDist[0][0][0] = 1;

        while (!pq.isEmpty()) {
            Pos poll = pq.poll();
            for (int i = 0; i < 4; i++) {
                int dr = poll.r + delta[i][0];
                int dc = poll.c + delta[i][1];
                if (dr < 0 || dc < 0 || dr >= N || dc >= M) continue;

                if (minDist[poll.breakWall][dr][dc] > poll.dist + 1) {
                    if (map[dr][dc] == 0) {
                        pq.offer(new Pos(dr, dc, poll.breakWall, poll.dist + 1));
                        minDist[poll.breakWall][dr][dc] = poll.dist + 1;
                    } else if (poll.breakWall == 0) {
                        pq.offer(new Pos(dr, dc, 1, poll.dist + 1));
                        minDist[1][dr][dc] = poll.dist + 1;
                    }
                }

            }
        }


    }
}
