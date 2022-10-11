package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10836_여왕벌 {
    static int[][] map, delta = {{-1, 0}, {0, 1}};
    static int[] grow;
    static int m, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[m][m];
        grow = new int[2 * m - 1];

        //day1 ~ day n
        for (int day = 0; day < n; day++) {
            //성장규칙 입력
            st = new StringTokenizer(br.readLine());
            int idx = 0;
            for (int j = 0; j < 3; j++) {
                int num = Integer.parseInt(st.nextToken());
                while (num-- > 0) {
                    grow[idx++] += j;
                }
            }
        }

        int dr = m - 1;
        int dc = 0;
        int d = 0;
        for (int i = 0; i < 2 * m - 1; i++) {
            map[dr][dc] = grow[i]+1;

            if (dr == dc) d++;
            dr += delta[d][0];
            dc += delta[d][1];
        }
        //성장!
        for (int c = m - 1; c > 0; c--) {
            int max = map[0][c];
            for (int r = 1; r < m; r++) {
                map[r][c] = max;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
