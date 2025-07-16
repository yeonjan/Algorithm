import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static class Building {
        int L, R, C;
        String[][][] building;
        int[] startPoint;

        public Building(int l, int r, int c, String[][][] building, int[] startPoint) {
            L = l;
            R = r;
            C = c;
            this.building = building;
            this.startPoint = startPoint;
        }

        public void printEscape() {
            int time = run();
            if (time == -1) System.out.println("Trapped!");
            else System.out.println("Escaped in " + time + " minute(s).");
        }

        public int run() {
            int[][] delta = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};
            int time = 0;

            ArrayDeque<int[]> queue = new ArrayDeque<>();
            boolean[][][] visited = new boolean[L][R][C];
            visited[startPoint[0]][startPoint[1]][startPoint[2]] = true;
            queue.add(startPoint);

            while (!queue.isEmpty()) {
                int cnt = queue.size();
                time++;
                for (int i = 0; i < cnt; i++) {
                    int[] poll = queue.poll();
                    for (int d = 0; d < 6; d++) {
                        int dl = poll[0] + delta[d][0];
                        int dr = poll[1] + delta[d][1];
                        int dc = poll[2] + delta[d][2];

                        if (dl < 0 || dl >= L || dr < 0 || dr >= R || dc < 0 || dc >= C) continue;

                        if (visited[dl][dr][dc]) continue;
                        if (building[dl][dr][dc].equals("E")) return time;
                        if (!building[dl][dr][dc].equals("#")) {
                            visited[dl][dr][dc] = true;
                            queue.offer(new int[]{dl, dr, dc});
                        }
                    }
                }
            }

            return -1;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            String[][][] building = new String[L][R][C];
            int[] startPoint = new int[3]; //floor, r,c
            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    building[l][r] = br.readLine().split("");
                    for (int c = 0; c < C; c++) {
                        if (building[l][r][c].equals("S")) startPoint = new int[]{l, r, c};
                    }
                }
                br.readLine();
            }

            new Building(L, R, C, building, startPoint).printEscape();


        }
    }


}
