package ssafy.사전학습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1961_숫자배열회전 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test = Integer.parseInt(br.readLine());

        for (int t = 1; t <= test; t++) {
            int n = Integer.parseInt(br.readLine());

            String[][] origin = new String[n][n];
            String[][] result = new String[n][n];
            for (int i = 0; i < n; i++) {
                origin[i] = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    result[i][j] = "";
                }
            }


            int x = 0;
            int y = 0;
            for (int i = 0; i < n; i++) {
                for (int j = n - 1; j >= 0; j--) {
                    //90도
                    result[i][0] += origin[j][i];
                    //180도
                    result[i][1] += origin[n - 1 - i][j];
                    //270도
                    result[i][2] += origin[n - 1 - j][n - 1 - i];
                }
            }

            sb.append("#" + t + "\n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(result[i][j] + " ");
                }
                sb.append("\n");
            }


        }
        System.out.println(sb);
    }

}
