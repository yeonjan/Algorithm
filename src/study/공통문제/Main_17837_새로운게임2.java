package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_17837_새로운게임2 {
    static int n;
    static int k;
    static int[][] delta = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    static int[][] map;
    static int[][][] pos;
    static boolean[] pass;
    static Piece[] pieces;

    static class Piece {
        int r;
        int c;
        int direct;

        public Piece(int r, int c, int direct) {
            this.r = r;
            this.c = c;
            this.direct = direct;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        pos = new int[3][n][n];
        pieces = new Piece[k + 1];
        pass = new boolean[k + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;
            pieces[i] = new Piece(r, c, d);
            pos[0][r][c] = i;

        }

        int turn = 0;
        TURN:
        while (turn <= 1000) {

            turn++;
            for (int i = 1; i <= k; i++) {


                Piece piece = pieces[i];
                int r = pieces[i].r;
                int c = pieces[i].c;
                int dr = piece.r + delta[piece.direct][0];
                int dc = piece.c + delta[piece.direct][1];

                //방향 변경
                if (dr >= n || dc >= n || dr < 0 || dc < 0 || map[dr][dc] == 2) {
                    int d = piece.direct % 2 == 0 ? piece.direct + 1 : piece.direct - 1;
                    piece.direct = d;
                    dr = piece.r + delta[d][0];
                    dc = piece.c + delta[d][1];
                    if (dr >= n || dc >= n || dr < 0 || dc < 0 || map[dr][dc] == 2) {
                        continue;
                    }
                }

                int height1 = 0;
                int height2 = 0;
                int start = 0;
                for (int j = 0; j < 3; j++) {
                    if (pos[j][dr][dc] != 0) height1++;
                    if (pos[j][r][c] != 0) {
                        if (pos[j][r][c] == i) start = j;
                        height2++;
                    }
                }

                if (height1 + height2 >= 4) break TURN;


                if (map[dr][dc] == 0) {
                    for (int j = start; j < height2; j++) {
                        int p = pos[j][r][c];
                        if (p == 0) continue;
                        pos[j-start + height1][dr][dc] = p;
                        pos[j][r][c] = 0;
                        pieces[p].r = dr;
                        pieces[p].c = dc;

                    }
                } else if (map[dr][dc] == 1) {
                    for (int j = height2 - 1; j >= start; j--) {
                        int p = pos[j][r][c];
                        if (p == 0) continue;
                        pos[height2 - 1 - j + height1][dr][dc] = p;
                        pos[j][r][c] = 0;
                        pieces[p].r = dr;
                        pieces[p].c = dc;
                    }
                }
            }


        }
        System.out.println(turn > 1000 ? -1 : turn);


    }


}
