package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17136_색종이붙이기 {
    static int SIZE = 10, ans = Integer.MAX_VALUE, total;
    static int[] colorPaper = new int[]{0, 5, 5, 5, 5, 5};
    static int[][] map = new int[10][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) total++;
            }
        }

        if (total == 0) {
            System.out.println(0);
            return;
        }
        dfs(colorPaper, total, 0, map);

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);


    }

    public static void dfs(int[] paper, int total, int cnt, int[][] map) {
        if (total == 0) {
            ans = Math.min(ans, cnt);
            return;
        }
        if (cnt > ans) {

            return;
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == 1) {
                    for (int s = 1; s <= 5; s++) {
                        if (paper[s] > 0 && check(i, j, s, map)) {
                            paper[s] -= 1;

                            int[][] map2 = new int[10][10];
                            for (int c = 0; c < 10; c++) {
                                map2[c] = map[c].clone();
                            }
                            for (int r = i; r < i + s; r++) {
                                for (int c = j; c < j + s; c++) {
                                    map2[r][c] = 0;
                                }
                            }
                            dfs(paper, total - (s * s), cnt + 1, map2);
                            paper[s] += 1;
                        }
                    }
                    return; // 5종류의 색종이를 모두 해본뒤 리턴하지 않으면 아래서 이미 갔던 1에 걸림
                }
            }

        }

    }

    public static boolean check(int i, int j, int size, int[][] map) {
        for (int r = i; r < i + size; r++) {
            for (int c = j; c < j + size; c++) {
                if (r < 0 || c < 0 || r >= 10 || c >= 10) return false;
                if (map[r][c] != 1) return false;
            }
        }

        return true;
    }
}

