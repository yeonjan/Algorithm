package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2001_파리퇴치_2 {
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

            int[] max = new int[size*size];

            int count = 0;
            for (int H = 0; H < size; H++) {
                for (int W = 0; W < size; W++) {
                    for (int h = 0; h < m; h++) {
                        for (int w = 0; w < m; w++) {
                            max[count] = max[count] + fly[H+h][W+w];
                        }
                    }
                    count++;
                }
            }
            Arrays.sort(max);

            sb.append("#" + t + " " + max[max.length-1] + "\n");
        }
        System.out.println(sb);
    }
}
