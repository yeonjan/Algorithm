package study.DFS_BFS;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main_11559_puyopuyo {
    static int ans;
    static boolean hasBomb = false;
    static char[][] map = new char[12][6];
    static boolean[] endCol = new boolean[6];
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean[][] visited = new boolean[12][6];
    static boolean[][] haveToExplode = new boolean[12][6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 12; i++) {
            map[i] = br.readLine().toCharArray();
        }

        while (true) {
            hasBomb = false;
            for (int i = 0; i < 12; i++) {
                Arrays.fill(haveToExplode[i], false);
                Arrays.fill(visited[i], false);
            }
            Arrays.fill(endCol, false);

            //연쇄가 있는지 찾기
            for (int r = 11; r >= 0; r--) {
                for (int c = 0; c < 6; c++) {
                    if (endCol[c]) continue;

                    //뿌요가 아닌경우! 더이상 해당 열에 뿌요 없음!
                    if (map[r][c] == '.') {
                        endCol[c] = true;
                        continue;
                    }

                    if (visited[r][c]) continue;

                    findBomb(r, c);
                }
            }
            //
            if (hasBomb) {
                afterPuyo();
                ans++;
            } else break;
        }
        System.out.println(ans);

    }

    public static void findBomb(int r, int c) {
        int cnt = 0;
        char target = map[r][c];
        boolean[][] bomb = new boolean[12][6];


        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            visited[poll[0]][poll[1]] = true;
            bomb[poll[0]][poll[1]] = true;
            cnt++;
            for (int i = 0; i < 4; i++) {
                int dr = poll[0] + delta[i][0];
                int dc = poll[1] + delta[i][1];
                if (dr < 0 || dc < 0 || dr >= 12 || dc >= 6) continue;

                if (!visited[dr][dc] && map[dr][dc] == target) {
                    queue.offer(new int[]{dr, dc});
                }
            }

        }
        if (cnt >= 4) {
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (bomb[i][j]) haveToExplode[i][j] = true;
                }
            }
            hasBomb = true;
        }
    }


    public static void afterPuyo() {
        int[] idx = new int[6];

        for (int r = 0; r < 12; r++) {
            for (int c = 0; c < 6; c++) {
                if (haveToExplode[r][c]) {
                    map[r][c] = '.';
                    idx[c] = Math.max(idx[c], r);
                }

            }
        }

        for (int c = 0; c < 6; c++) {
            for (int r = 11; r >= 0; r--) {
                if (r < idx[c] && map[r][c] != '.') {
                    map[idx[c]][c] = map[r][c];
                    map[r][c] = '.';
                    idx[c]--;
                }
            }
        }

    }
}

