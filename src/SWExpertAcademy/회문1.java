package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 회문1 {
    static String[][] arr = new String[8][8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= 10; i++) {
            int length = Integer.parseInt(br.readLine());
            for (int k = 0; k < 8; k++) {
                arr[k] = br.readLine().split("");
            }
            System.out.println("#"+i+" "+UserSolution(length));
        }

    }

    public static int UserSolution(int n) {
        String[] row = new String[n];
        String[] column = new String[n];
        int count = 0;

        for (int h = 0; h < 8; h++) {
            for (int i = 0; i < 9-n; i++) {
                for (int k = 0; k < n; k++) {
                    row[k] = arr[h][k+i];
                    column[k] = arr[k+i][h];
                }
                count += isP(row);
                count += isP(column);
            }
        }
        return count;
    }

    public static int isP(String[] p) {
        int count = 0;
        int n =p.length;
        for (int i = 0; i < n / 2; i++) {
            if (p[i].equals(p[n-i-1])) count++;
        }
        if (count == n / 2) return 1;
        else return 0;

    }
}
