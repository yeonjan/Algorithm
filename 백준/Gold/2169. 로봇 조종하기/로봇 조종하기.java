import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int n, m;
    static int[][] map;
    static int[][] dp;
    static int[][] temp;
    static int[][] delta = {{0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dp = new int[n][m];
        temp = new int[2][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        initDp();

        for (int r = 1; r < n; r++) {
            //왼쪽으로
            temp[0][0] = dp[r - 1][0] + map[r][0];
            for (int c = 1; c < m; c++) {
                temp[0][c] = Math.max(temp[0][c - 1], dp[r - 1][c]) + map[r][c];
            }

            //오른쪽으로
            temp[1][m-1] = dp[r - 1][m-1] + map[r][m-1];
            for (int c = m-2; c >= 0; c--) {
                temp[1][c] = Math.max(temp[1][c + 1], dp[r - 1][c]) + map[r][c];
            }
            for(int c=0;c<m;c++){
                dp[r][c]=Math.max(temp[0][c], temp[1][c]);
            }
        }
        System.out.println(dp[n - 1][m - 1]);


    }

    public static void initDp() {
        dp[0][0] = map[0][0];
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] + map[0][i];
        }
        for (int r = 1; r < n; r++) {
            Arrays.fill(dp[r], Integer.MIN_VALUE);
        }
    }


    private static boolean isInLine(int dr, int dc) {
        return !(dr < 0 || dc < 0 || dr >= n || dc >= m);
    }


}
