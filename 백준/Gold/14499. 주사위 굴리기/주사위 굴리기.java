import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Dice {
        List<Integer> infos;

        public Dice() {
            this.infos = Arrays.asList(0, 0, 0, 0, 0, 0);
        }

        public void move(int direct) {
            int temp;
            switch (direct) {
                case 0:
                    temp = infos.get(0);
                    infos.set(0, infos.get(3));
                    infos.set(3, infos.get(5));
                    infos.set(5, infos.get(2));
                    infos.set(2, temp);
                    break;
                case 1:
                    temp = infos.get(0);
                    infos.set(0, infos.get(2));
                    infos.set(2, infos.get(5));
                    infos.set(5, infos.get(3));
                    infos.set(3, temp);
                    break;
                case 2:
                    temp = infos.get(0);
                    infos.set(0, infos.get(4));
                    infos.set(4, infos.get(5));
                    infos.set(5, infos.get(1));
                    infos.set(1, temp);
                    break;
                case 3:
                    temp = infos.get(0);
                    infos.set(0, infos.get(1));
                    infos.set(1, infos.get(5));
                    infos.set(5, infos.get(4));
                    infos.set(4, temp);
                    break;

            }
        }

        public int getTop() {
            return infos.get(0);
        }

        public int getBottom() {
            return infos.get(5);
        }

        public void changeBottom(int num) {
            infos.set(5, num);
        }

    }

    public static void solve(int n, int m, int[] start, int[][] map, List<Integer> cmd) {
        int r = start[0];
        int c = start[1];
        int[][] delta = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Dice dice = new Dice();
        for (int i = 0; i < cmd.size(); i++) {
            int direct = cmd.get(i) - 1;
            int dr = r + delta[direct][0];
            int dc = c + delta[direct][1];
            if (dr < 0 || dc < 0 || dr >= n || dc >= m) continue;

            dice.move(direct);
// 숫자 변경 규칙
// 칸=0  >> 바닥면 숫자를 칸으로 변경
// 칸!=0 >> 칸의 숫자 바닥면으로 변경/ 칸=0
            if (map[dr][dc] == 0) {
                map[dr][dc] = dice.getBottom();
            } else {
                dice.changeBottom(map[dr][dc]);
                map[dr][dc] = 0;
            }
            System.out.println(dice.getTop());
            r = dr;
            c = dc;
        }

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int startR = Integer.parseInt(st.nextToken());
        int startC = Integer.parseInt(st.nextToken());
        List<Integer> cmd = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            cmd.add(Integer.valueOf(st.nextToken()));
        }

        solve(n, m, new int[]{startR, startC}, map, cmd);

    }


}
