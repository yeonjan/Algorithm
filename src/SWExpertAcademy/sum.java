package SWExpertAcademy;

import java.util.*;
import java.io.*;

public class sum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int test_case = 1; test_case <= 10; test_case++) {
            int n = Integer.parseInt(br.readLine());
            String[][] input = new String[100][100];
            int[] sum = new int[202];


            for (int i = 0; i < 100; i++) {
                input[i] = br.readLine().split(" ");
            }

            // 행열 합
            for (int h = 0; h < 100; h++) {
                for (int w = 0; w < 100; w++) {
                    sum[h] += Integer.parseInt(input[h][w]);
                    sum[100+h] += Integer.parseInt(input[w][h]);
                }
            }
            // 대각

            for (int h = 0; h < 100; h++) {
                for (int w = 0; w < 100; w++) {
                    if (w == h) {
                        sum[200] += Integer.parseInt(input[h][w]);
                    }
                    if (w + h == 99) {
                        sum[201] += Integer.parseInt(input[h][w]);
                    }
                }
            }
            Arrays.sort(sum);
            System.out.println("#"+test_case+" "+sum[201]);

        }

    }
}