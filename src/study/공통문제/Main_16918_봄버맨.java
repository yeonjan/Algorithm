package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16918_봄버맨 {
    static int R, C, N;
    static int[][] map;
    static boolean[][] check;
    static int[][] delta = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                if (input.charAt(j) == '.') map[i][j] = -10;
            }
        }

        for (int n = 2; n <= N; n++) {
            if (n % 2 == 0) setBomb(n);
            else bomb(n);
        }

        //출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] < 0) sb.append('.');
                else sb.append('O');
            }
            sb.append("\n");
        }
        System.out.println(sb);


    }

    public static void setBomb(int n) {
        check = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] < 0) map[i][j] = n;
            }
        }
    }

    public static void bomb(int n) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == n - 3) {
                    check[i][j] = true;
                    for (int d = 0; d < 4; d++) {
                        int dr = i + delta[d][0];
                        int dc = j + delta[d][1];

                        if (dr >= 0 && dc >= 0 && dr < R && dc < C) check[dr][dc] = true;
                    }
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (check[i][j]) {
                    map[i][j] = -10;
                }
            }
        }
    }

}
