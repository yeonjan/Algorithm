package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 달팽이숫자 {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; ++i) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            snail(n);

            sb.append("#").append(i+1).append("\n");
            for (int h = 0; h < n; h++) {
                for (int w = 0; w < n; w++) {
                    sb.append(arr[h][w]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void snail(int n) {
        int num = 0;
        int nowX = -1;
        int nowY = 0;
        int rotate = 0;
        int max = n * n;

        while (true) {
            for (int x = nowX + 1; x < n-rotate; x++) {
                num++;
                arr[nowY][x] = num;
                nowX = x;
                if (num == max) return;
            }
            for (int y = nowY + 1; y < n-rotate; y++) {
                num++;
                arr[y][nowX] = num;
                nowY = y;
                if (num == max) return;
            }

            for (int x = nowX - 1; x >= rotate; x--) {
                num++;
                arr[nowY][x] = num;
                nowX = x;
                if (num == max) return;
            }

            for (int y = nowY - 1; y > rotate; y--) {
                num++;
                arr[y][nowX] = num;
                nowY = y;
                if (num == max) return;
            }

            rotate++;
        }

    }
}
