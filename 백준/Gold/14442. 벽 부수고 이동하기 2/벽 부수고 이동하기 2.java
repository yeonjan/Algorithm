import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int MAX_VALUE=2000000;
    static int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, M, K;
        int ans = Integer.MAX_VALUE;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        int[][][] min = bfs(N, M, K, map);

        for (int k = 0; k <= K; k++) {
            ans = Math.min(ans, min[k][N - 1][M - 1]);
        }
        System.out.println(ans!=MAX_VALUE?ans:-1);

    }

    public static int[][][] bfs(int N, int M, int K, int[][] map) {
        int[][][] min = new int[K + 1][N][M];
        for (int k = 0; k <= K; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    min[k][i][j] = MAX_VALUE;
                }
            }

        }
        ArrayDeque<int[]> queue = new ArrayDeque<>(); //r,c,k,dist
        min[K][0][0] = 1;
        queue.offer(new int[]{0, 0, K, 1});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int k = cur[2];
            int dist = cur[3];

            for (int d = 0; d < 4; d++) {
                int dr = r + delta[d][0];
                int dc = c + delta[d][1];

                if (dr < 0 || dc < 0 || dr >= N || dc >= M) continue;

                //갈 수 없음
                if (k == 0 && map[dr][dc] == 1) continue;

                if (map[dr][dc] == 1 && dist + 1 < min[k - 1][dr][dc]) {
                    min[k - 1][dr][dc] = dist + 1;
                    queue.offer(new int[]{dr, dc, k - 1, dist + 1});
                }

                if (map[dr][dc] == 0 && dist + 1 < min[k][dr][dc]) {
                    min[k][dr][dc] = dist + 1;
                    queue.offer(new int[]{dr, dc, k, dist + 1});
                }
            }
        }


        return min;
    }


}