import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;
    static int[][] map;
    static int[][] min;
    static int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int gameNum = 0;
        while (true) {
            gameNum++;
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            map = new int[N][N];
            min = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    min[i][j] = Integer.MAX_VALUE;
                    map[i][j] = Integer.parseInt(st.nextToken());
                }

            }
            dijkstra();
            sb.append("Problem ").append(gameNum).append(": ").append(min[N - 1][N - 1]).append("\n");

        }
        System.out.println(sb);

    }

    public static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.add(new int[]{0, 0, map[0][0]});
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            if (poll[0] == N - 1 && poll[1] == N - 1) {
                continue;
            }
            int rupee = poll[2];
            for (int[] d : delta) {
                int dr = poll[0] + d[0];
                int dc = poll[1] + d[1];

                if (dr < 0 || dc < 0 || dr >= N || dc >= N) continue;
                if (min[dr][dc] > rupee + map[dr][dc]) {
                    min[dr][dc] = rupee + map[dr][dc];
                    pq.offer(new int[]{dr, dc, map[dr][dc] + rupee});

                }
            }
        }

    }


}