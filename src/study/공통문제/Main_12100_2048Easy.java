import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12100_2048Easy {
    static int n, ans;
    static boolean isEnd;
    static int[][] mapOrigin, map;
    static int[][] delta = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[] select = new int[5];
    static Point pos, start;

    static class Point {
        int r, c, value;

        Point(int r, int c, int value) {
            this.r = r;
            this.c = c;
            this.value = value;
        }

        void copy(Point p) {
            this.r = p.r;
            this.c = p.c;
            this.value = p.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        mapOrigin = new int[n][n];
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                mapOrigin[i][j] = Integer.parseInt(st.nextToken());
                ans=Math.max(ans,mapOrigin[i][j]);
            }
        }
        comb(0);

        System.out.println(ans);
    }

    public static void comb(int cnt) {
        if (cnt == 5) {
            for (int i = 0; i < n; i++) {
                map[i] = mapOrigin[i].clone();
            }
            for (int i = 0; i < 5; i++) {
                setDirection(select[i]);
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            select[cnt] = i;
            comb(cnt + 1);
        }
    }

    public static void setDirection(int direct) {
        //UP
        if (direct == 0) {
            for (int i = 0; i < n; i++) {
                isEnd = true;
                start = new Point(-1, -1, 0);
                pos = new Point(0, i, 0);
                for (int j = 0; j < n; j++) {
                    move(j, i, direct);
                }
                check();
            }
        }
        // DOWN
        else if (direct == 1) {
            for (int i = 0; i < n; i++) {
                isEnd = true;
                start = new Point(-1, -1, 0);
                pos = new Point(n - 1, i, 0);
                for (int j = n - 1; j >= 0; j--) {
                    move(j, i, direct);
                }
                check();
            }
        }
        //LEFT
        else if (direct == 2) {
            for (int i = 0; i < n; i++) {
                isEnd = true;
                start = new Point(-1, -1, 0);
                pos = new Point(i, 0, 0);
                for (int j = 0; j < n; j++) {
                    move(i, j, direct);
                }
                check();
            }
        }
        //RIGHT
        else {
            for (int i = 0; i < n; i++) {
                isEnd = true;
                start = new Point(-1, -1, 0);
                pos = new Point(i, n - 1, 0);
                for (int j = n - 1; j >= 0; j--) {
                    move(i, j, direct);
                }
                check();
            }
        }
    }

    public static void check() {
        if (!isEnd) {
            map[start.r][start.c] = 0;
            map[pos.r][pos.c] = start.value;
        }
    }

    public static void move(int i, int j, int d) {
        if (map[i][j] != 0) {
            //start 값이 없다면 처음으로 들어오는 값 설정
            if (start.r == -1 && start.c == -1) {
                start.r = i;
                start.c = j;
                start.value = map[i][j];
                isEnd = false;
                return;
            }
            Point end = new Point(i, j, map[i][j]);

            if (start.value == end.value) {
                map[start.r][start.c] = 0;
                map[end.r][end.c] = 0;
                map[pos.r][pos.c] = start.value * 2;
                ans = Math.max(ans, map[pos.r][pos.c]);
                start.r = -1;
                start.c = -1;
                isEnd = true;
            } else {
                map[start.r][start.c] = 0;
                map[pos.r][pos.c] = start.value;
                start.copy(end);
                isEnd = false;
            }
            pos.r += delta[d][0];
            pos.c += delta[d][1];

        }
    }
}
