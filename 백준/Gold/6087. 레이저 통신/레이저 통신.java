import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int W, H;
    static char[][] map;
    static int[][][] cntMirror;
    static int ans = Integer.MAX_VALUE;
    static int[][] delta = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static class Laser {
        int r, c;
        int d;
        int usedMirror;

        public Laser(int r, int c, int d, int usedMirror) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.usedMirror = usedMirror;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new char[H][W];
        cntMirror = new int[H][W][4];
        ;
        for (int i = 0; i < H; i++) {
            char[] input = br.readLine().toCharArray();
            map[i] = input;
            for (int j = 0; j < W; j++) {
                for (int d = 0; d < 4; d++) {
                    cntMirror[i][j][d] = Integer.MAX_VALUE;
                }
            }
        }

        boolean isFirst = true;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (isFirst && map[i][j] == 'C') {
                    bfs(i, j);
                    isFirst = false;
                } else if (!isFirst && map[i][j] == 'C') {
                    for (int d = 0; d < 4; d++) {
                        ans = Math.min(ans, cntMirror[i][j][d]);
                    }
                }
            }
        }

        System.out.println(ans);

    }

    public static void bfs(int r, int c) {
        PriorityQueue<Laser> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.usedMirror, o2.usedMirror));


        //r, c, 방향, 거울
        for (int i = 0; i < 4; i++) {
            int dr = r + delta[i][0];
            int dc = c + delta[i][1];
            if (dr < 0 || dc < 0 || dr >= H || dc >= W) continue;
            if (map[dr][dc] == '*') continue;
            pq.add(new Laser(dr, dc, i, 0));
            cntMirror[dr][dc][i] = 0;
        }


        while (!pq.isEmpty()) {
            Laser cur = pq.poll();
            if (cur.r != r && cur.c != c && map[cur.r][cur.c] == 'C') continue;
            for (int i = -1; i <= 1; i++) {
                int d = (4 + cur.d + i) % 4;
                int dr = cur.r + delta[d][0];
                int dc = cur.c + delta[d][1];
                int mirror = (i == 0 ? cur.usedMirror : cur.usedMirror + 1);

                if (dr < 0 || dc < 0 || dr >= H || dc >= W) continue;
                if (map[dr][dc] == '*') continue;
                if (cntMirror[dr][dc][d] > mirror) {
                    cntMirror[dr][dc][d] = mirror;
                    pq.add(new Laser(dr, dc, d, mirror));
                }

            }

        }

    }


}

