package backjun.알고리즘기초.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 사탕게임 {
    static int answer;
    static char[][] map;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        // 우, 하
        int[][] delta = {{0, 1}, {1, 0}};
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        eat();
        if (answer != n) {
            search(delta);
        }

        System.out.println(answer);
    }

    public static void search(int[][] delta) {
        for (int h = 0; h < n - 1; h++) {
            for (int w = 0; w < n; w++) {
                for (int[] ints : delta) {
                    char now = map[h][w];
                    int nearH = h + ints[0];
                    int nearW = w + ints[1];

                    if (nearH >= 0 && nearH < n && nearW >= 0 && nearW < n && map[nearH][nearW] != now) {
                        change(nearH, nearW, h, w);
                        eat();
                        change(h, w, nearH, nearW);
                    }
                }
            }
        }
    }

    public static void change(int fromH, int fromW, int toH, int toW) {
        char temp = map[fromH][fromW];
        map[fromH][fromW] = map[toH][toW];
        map[toH][toW] = temp;
    }

    public static void eat() {
        int tempR;
        int tempC;

        for (int h = 0; h < n; h++) {
            tempR = tempC = 0;
            for (int w = 0; w < n - 1; w++) {
                if (map[h][w] == map[h][w + 1]) {
                    tempR++;
                } else {
                    answer = Math.max(answer, tempR + 1);
                    tempR = 0;
                }

                if (map[w][h] == map[w + 1][h]) {
                    tempC++;
                } else {
                    answer = Math.max(answer, tempC + 1);
                    tempC = 0;
                }
            }
            answer = Math.max(answer, tempR + 1);
            answer = Math.max(answer, tempC + 1);
        }
    }
}
