package ssafy.과제._0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BJ_17135_캐슬디펜스 {
    static int N, M, D, ans, cnt;
    static boolean[][] map, map2;
    static boolean[] castle;
    static int[] deltaR = {0, -1, 0}, deltaC = {-1, 0, 1};
    static Queue<int[]> attacked = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        map2 = new boolean[N][M];
        castle = new boolean[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if (Integer.parseInt(st.nextToken()) == 0) map[i][j] = false;
                else map[i][j] = true;
            }
        }

        dfs(0, M - 1);
        System.out.println(ans);
    }

    public static void dfs(int depth, int start) {
        if (depth == 3) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map2[i][j] = map[i][j];
                }
            }
            cnt = 0;
            routine(0);
            ans = Math.max(ans, cnt);
            return;
        }
        for (int i = start; i >= 0; i--) {
            if (!castle[i]) {
                castle[i] = true;
                dfs(depth + 1, i - 1);
                castle[i] = false;
            }
        }
    }

    public static void routine(int count) {
        if (count == N) return;
        for (int i = 0; i < M; i++) {
            if (castle[i]) attack(new int[]{N, i});
        }
        while (!attacked.isEmpty()) {
            int[] enemy = attacked.poll();
            if (map2[enemy[0]][enemy[1]]) {
                map2[enemy[0]][enemy[1]] = false;
                cnt++;
            }
        }
        move();
        routine(count + 1);
    }

    public static void attack(int[] point) {
        LinkedList<int[]> queue = new LinkedList<>();
        int dist = 0;
        queue.offer(point);
        END:
        while (!queue.isEmpty()) {
            dist++;
            if (dist > D) break;
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] poll = queue.poll();
                for (int i = 0; i < 3; i++) {
                    int dr = poll[0] + deltaR[i];
                    int dc = poll[1] + deltaC[i];
                    if (dr < 0 || dc < 0 || dr >= N || dc >= M) continue;
                    int[] target = new int[]{dr, dc};
                    if (!map2[dr][dc]) {
                        queue.offer(target);
                    } else {
                        attacked.offer(target);
                        break END;
                    }
                }
            }
        }
    }

    public static void move() {
        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j < M; j++) {
                map2[i + 1][j] = map2[i][j];
            }
        }
        Arrays.fill(map2[0], false);
    }

}

