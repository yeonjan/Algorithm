package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926_배열돌리기1 {
    static int n, m, r, minL;
    static int[][] arr;
    static int[][] newArr;
    static int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        newArr = new int[n][m];
        minL = Math.min(n, m);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        rotate(0);

    }

    public static void rotate(int cnt) {
        if (cnt == r) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    sb.append(arr[i][j] + " ");
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
            return;

        }

        //rotate
        int length;
        for (int start = 0; start < minL / 2; start++) {
            int r = start;
            int c = start;
            int dr;
            int dc;
            for (int d = 0; d < 4; d++) {
                if (d % 2 == 0) length = m - 1 - start * 2;
                else length = n - 1 - start * 2;

                for (int i = 0; i < length; i++) {
                    dr = r + delta[d][0];
                    dc = c + delta[d][1];
                    newArr[r][c] = arr[dr][dc];

                    r = dr;
                    c = dc;
                }
            }
        }
        //arr <- newArr
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = newArr[i][j];
            }
        }

        rotate(cnt + 1);


    }
}
