package ssafy.사전학습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2001_파리퇴치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test = Integer.parseInt(br.readLine());

        for (int t = 1; t <= test; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int size = n - m + 1;

            int[][] fly = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    fly[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] compress = new int[n][n - m + 1];
            for (int h = 0; h < n; h++) {
                for (int w = 0; w < n - m + 1; w++) {
                    int sum = 0;
                    for (int i = w; i < w + m; i++) {
                        sum += fly[h][i];
                    }
                    compress[h][w] = sum;
                }
            }

            int result = 0;
            for (int w = 0; w < n-m+1; w++) {
                for (int h = 0; h < n - m + 1; h++) {
                    int sum = 0;
                    for (int i = h; i < h + m; i++) {
                        sum += compress[i][w];
                    }
                    result = Math.max(sum, result);
                }
            }
            sb.append("#" + t + " " + result + "\n");
        }
        System.out.println(sb);
    }
}
