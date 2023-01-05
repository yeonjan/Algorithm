package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1600_말이되고픈원숭이 {
    static int k, w, h, minDist=-1;
    static int[][] map;
    static int[][][] dist;
    static int[][] deltaHorse = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
    static int[][] deltaMonkey = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static class Monkey {
        int r, c, k, dist;

        public Monkey(int r, int c, int k, int dist) {
            this.r = r;
            this.c = c;
            this.k = k;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][w];
        dist = new int[k + 1][h][w];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                for (int l = 0; l <= k; l++) {
                    dist[l][i][j] = Integer.MAX_VALUE;
                }
            }
        }

        bfs();

        System.out.println(minDist);


    }

    public static void bfs() {
        PriorityQueue<Monkey> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.dist == o2.dist) return Integer.compare(o1.k, o2.k);
            return Integer.compare(o1.dist, o2.dist);
        });

        pq.offer(new Monkey(0, 0, k, 0));
        dist[k][0][0] = 0;

        while (!pq.isEmpty()) {
            Monkey monkey = pq.poll();

            if (monkey.r == h - 1 && monkey.c == w - 1) {
                minDist = monkey.dist;
                break;

            }
            //말 이동
            if (monkey.k > 0) {
                for (int d = 0; d < 8; d++) {
                    int dr = monkey.r + deltaHorse[d][0];
                    int dc = monkey.c + deltaHorse[d][1];
                    //범위 밖에 있거나 장애물에 있을 때
                    if (!check(dr, dc) || map[dr][dc] == 1) continue;

                    // dist가 작은 경우
                    if (dist[monkey.k - 1][dr][dc] > monkey.dist + 1) {
                        pq.offer(new Monkey(dr, dc, monkey.k - 1, monkey.dist + 1));
                        dist[monkey.k - 1][dr][dc] = monkey.dist + 1;
                    }
                }
            }

            //원숭이 이동~~~
            for (int d = 0; d < 4; d++) {
                int dr = monkey.r + deltaMonkey[d][0];
                int dc = monkey.c + deltaMonkey[d][1];
                //범위 밖에 있거나 장애물에 있을 때
                if (!check(dr, dc) || map[dr][dc] == 1) continue;

                //k가 더 많이 남았거나 dist가 작은 경우
                if (dist[monkey.k][dr][dc] > monkey.dist + 1) {
                    pq.offer(new Monkey(dr, dc, monkey.k, monkey.dist + 1));
                    dist[monkey.k][dr][dc] = monkey.dist + 1;
                }
            }


        }
    }

    public static boolean check(int r, int c) {
        return r >= 0 && c >= 0 && r < h && c < w;
    }
}