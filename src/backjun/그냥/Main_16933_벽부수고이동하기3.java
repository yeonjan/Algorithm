package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_16933_벽부수고이동하기3 {
    static int N, M, K;
    static int[][] map;
    static int[][] maxK;
    static int[][] delta = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static class Pos {
        int x, y;
        int dist;
        int k;

        public Pos(int x, int y, int dist, int k) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.k = k;
        }

        public boolean isDay() {
            return dist % 2 == 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        maxK = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 1; j <= M; j++) {
                map[i][j] = input[j - 1] - '0';
                maxK[i][j] = -1;
            }
        }
        int ans = bfs();


        System.out.println(ans);
    }

    public static int bfs() {
        PriorityQueue<Pos> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1.dist, o2.dist);
        });
        pq.add(new Pos(1, 1, 1, K));
        maxK[1][1] = K;
        //dist 홀수-낮 / 짝수 - 밤
        while (!pq.isEmpty()) {
            Pos pos = pq.poll();
            if (pos.x == N && pos.y == M) {
                return pos.dist;
            }

            //이동
            for (int d = 0; d < 4; d++) {
                int dx = pos.x + delta[d][0];
                int dy = pos.y + delta[d][1];

                if (dx < 1 || dy < 1 || dx > N || dy > M) continue;

                if (!pos.isDay() && map[dx][dy] == 1) {
                    continue;
                }

                if (map[dx][dy] == 0) {
                    if (pos.k > maxK[dx][dy]) {
                        maxK[dx][dy] = pos.k;
                        pq.add(new Pos(dx, dy, pos.dist + 1, pos.k));
                    }
                } else {
                    if (pos.isDay() && pos.k - 1 > maxK[dx][dy]) {
                        maxK[dx][dy] = pos.k - 1;
                        pq.add(new Pos(dx, dy, pos.dist + 1, pos.k - 1));
                    }
                }

            }
            //재자리
            if (!pos.isDay()) {
                pq.add(new Pos(pos.x, pos.y, pos.dist + 1, pos.k));
            }
        }
        return -1;


    }

}

