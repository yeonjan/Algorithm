package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 파스칼의삼각형 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append("\n");

            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[n][n];

            // 처음과 끝 1로
            for (int i = 0; i < n; i++) {
                // 처음과 끝 1로
                arr[i][0] = 1;
                arr[i][i] = 1;

                // 중간 채우기
                if (i > 1) {
                    int at = 0;
                    for (int k = 1; k < i; k++) {
                        arr[i][k] = arr[i - 1][at];
                        at++;
                        arr[i][k] += arr[i - 1][at];
                    }

                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 0)
                        continue;
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }

        }
        System.out.println(sb);

    }
}
