package ssafy.과제._0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1954_달팽이숫자_정연진 {
    static int[][] map;
    static int n;
    static int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            cnt = 1;

            snail(n, 0, -1, 0, 1);

            // 출력
            sb.append("#" + t + "\n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(map[i][j] + " ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void snail(int size, int h, int w, int d, int num) {
        if (num <= n * n) {
            if (d == 4) d = 0;

            int deltaH = delta[d][0];
            int deltaW = delta[d][1];

            for (int i = 0, idx = 1; i < size; i++) {
                h += idx * deltaH;
                w += idx * deltaW;
                map[h][w] = num++;
            }
            cnt--;
            d++;
            if (cnt == 0) {
                size--;
                cnt = 2;
            }
            snail(size, h, w, d, num);
        }
    }
}
