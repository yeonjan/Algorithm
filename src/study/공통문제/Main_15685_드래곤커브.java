package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15685_드래곤커브 {
    static boolean[][] map = new boolean[101][101];
    static int[][] delta = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    static int x, y, d, g,ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            dragon();
        }
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    public static void dragon() {
        List<Integer> direction = new ArrayList<>();
        direction.add(d);
        for (int i = 0; i < g; i++) {
            int size = direction.size();
            for (int di = size - 1; di >= 0; di--) {
                direction.add((direction.get(di) + 1) % 4);
            }
        }
        map[y][x] = true;
        for (int direct : direction) {
            y += delta[direct][0];
            x += delta[direct][1];
            map[y][x] = true;
        }
    }
}
