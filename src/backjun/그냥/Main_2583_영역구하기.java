package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2583_영역구하기 {
    static int M;
    static int N;
    static int K;
    static int count=0;
    static boolean[][] map;
    static boolean[][] visit;
    static int[][] delta = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new boolean[M][N];
        visit = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            fill(x1, y1, x2, y2);

        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int c = 0; c < N; c++) {
            for (int r = 0; r < M; r++) {
                if (!map[r][c] && !visit[r][c]) {
                    count++;
                    ans.add(bfs(new int[]{r, c}));
                }
            }
        }
        Collections.sort(ans);
        StringBuilder sb = new StringBuilder();
        for (int a : ans) {
            sb.append(a).append(" ");
        }
        System.out.println(count);
        System.out.println(sb);

    }

    public static int bfs(int[] start) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int cnt = 0;
        visit[start[0]][start[1]] = true;
        queue.offer(new int[]{start[0], start[1]});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            cnt++;
            for (int d = 0; d < 4; d++) {
                int dr = poll[0] + delta[d][0];
                int dc = poll[1] + delta[d][1];

                if (dr < 0 || dc < 0 || dr >= M || dc >= N) continue;
                if (!map[dr][dc] && !visit[dr][dc]) {
                    visit[dr][dc] = true;
                    queue.offer(new int[]{dr, dc});
                }
            }


        }
        return cnt;
    }

    public static void fill(int x1, int y1, int x2, int y2) {
        for (int c = x1; c < x2; c++) {
            for (int r = y1; r < y2; r++) {
                map[r][c] = true;
            }
        }

    }
}
