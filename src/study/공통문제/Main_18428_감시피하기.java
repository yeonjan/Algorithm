package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18428_감시피하기 {
    static int n;
    static char[][] map;
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        obstacle(0);
        System.out.println("NO");


    }

    public static void obstacle(int cnt) {
        if (cnt == 3) {
            if (watch()) {
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'X') {
                    map[i][j] = 'O';
                    obstacle(cnt + 1);
                    map[i][j] = 'X';
                }
            }
        }

    }

    public static boolean watch() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'T') {
                    for (int d = 0; d < 4; d++) {
                        int dr = i + delta[d][0];
                        int dc = j + delta[d][1];

                        while (check(dr, dc)) {
                            if (map[dr][dc] == 'O') break;
                            else if (map[dr][dc] == 'S') return false;
                            dr += delta[d][0];
                            dc += delta[d][1];
                        }
                    }
                }
            }
        }
        return true;

    }

    public static boolean check(int dr, int dc) {
        return dr >= 0 && dc >= 0 && dr < n && dc < n;
    }
}
