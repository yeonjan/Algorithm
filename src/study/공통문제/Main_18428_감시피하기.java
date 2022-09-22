package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_18428_감시피하기 {
    static int n;
    static List<int[]> teacher = new ArrayList<>();
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
                if (map[i][j] == 'T') teacher.add(new int[]{i, j});
            }
        }

        obstacle(0);
        System.out.println("NO");
    }

    //장애물 위치 고르기
    public static void obstacle(int cnt) {
        if (cnt == 3) {
            if (!watch()) {
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

    //감시에 학생이 발견되면 true, 발견되지 않으면 false
    public static boolean watch() {
        for (int[] t : teacher) {
            for (int d = 0; d < 4; d++) {
                int dr = t[0] + delta[d][0];
                int dc = t[1] + delta[d][1];

                //dr,dc가 map 범위에서 벗어날 때까지 탐색
                while (check(dr, dc)) {
                    if (map[dr][dc] == 'O') break; // 장애물을 만나면 탐색 종료
                    else if (map[dr][dc] == 'S') return true; // 학생을 만나면 true를 리턴

                    dr += delta[d][0];
                    dc += delta[d][1];
                }
            }
        }
        return false;

    }

    public static boolean check(int dr, int dc) {
        return dr >= 0 && dc >= 0 && dr < n && dc < n;
    }
}