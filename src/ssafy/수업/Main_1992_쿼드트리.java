package ssafy.수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1992_쿼드트리 {
    static int n;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
        divNCon(n, 0, 0);
        String output = sb.toString();
        if (output.equals("(0000)")) System.out.println(0);
        else if (output.equals("(1111)")) System.out.println(1);
        else System.out.println(output);
    }

    public static void divNCon(int size, int r, int c) {
        if (size == 1) {
            sb.append(arr[r][c]);
            return;
        }

        sb.append("(");

        int half = size / 2;
        conquer(size, r, c);
        conquer(size, r, c + half);
        conquer(size, r + half, c);
        conquer(size, r + half, c + half);

        sb.append(")");
    }

    public static void conquer(int size, int r, int c) {
        int half = size / 2;
        int point = half * half;
        int zero, one;
        zero = one = 0;
        for (int i = r; i < r + half; i++) {
            for (int j = c; j < c + half; j++) {
                int cur = arr[i][j];
                if (cur == 0) zero++;
                else one++;
            }
        }
        if (zero == point) sb.append("0");
        else if (one == point) sb.append("1");
        else divNCon(size / 2, r, c);
    }
}
