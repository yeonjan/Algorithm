package backjun.단계9재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 별찍기 {
    static StringBuilder sb = new StringBuilder();
    static boolean[][] pos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        pos = new boolean[n][n];
        star(n, 0, 0);
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (pos[x][y]) {
                    sb.append("*");
                } else sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());


    }

    public static void star(int n, int x, int y) {
        if (n == 1) {
            pos[x][y] = true;
            return;
        }
        int step = n / 3;
        for (int h = y; h < y + n; h += step) {
            for (int w = x; w < x + n; w += step) {
                if ((w - x) == step && (h - y) == step) continue;
                star(n / 3, w, h);
            }
        }

    }
}
