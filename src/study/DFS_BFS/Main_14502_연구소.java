package study.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_14502_연구소 {
    static int N, M, ans;
    static int[][] map, selected, delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static List<int[]> virus = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        selected = new int[3][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) virus.add(new int[]{i, j});
            }
        }
        comb(0, 0);
        System.out.println(ans);
    }

    public static void comb(int cnt, int start) {
        if (cnt == 3) {
            int safe = bfs();
            ans = Math.max(ans, safe);
            return;
        }

        for (int i = start; i < N * M; i++) {
            int r = i / M;
            int c = i % M;
            if (map[r][c] == 0) {
                selected[cnt][0] = r;
                selected[cnt][1] = c;
                comb(cnt + 1, i + 1);
            }
        }
    }

    public static int bfs() {
        int cnt = 0;
        LinkedList<int[]> queue = new LinkedList<>();
        int[][] map2 = new int[N][M];
        for (int i = 0; i < N; i++) {
            map2[i] = map[i].clone();
        }
        for (int[] s : selected) {
            map2[s[0]][s[1]] = 1;
        }
        for (int[] v : virus) {
            queue.offer(v);
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int dr = poll[0] + delta[i][0];
                int dc = poll[1] + delta[i][1];
                if (dr < 0 || dr >= N || dc < 0 || dc >= M) continue;

                if (map2[dr][dc] == 0) {
                    map2[dr][dc] = 2;
                    queue.offer(new int[]{dr, dc});
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map2[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }
}