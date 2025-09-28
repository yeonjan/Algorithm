import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int R, C;
    static char[][] map;
    static ArrayDeque<int[]> fireQ = new ArrayDeque<>();


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int[] jihoon = new int[2];
        map = new char[R][C];


        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'J') {
                    jihoon = new int[]{i, j};
                    map[i][j] = '.';
                } else if (map[i][j] == 'F') fireQ.offer(new int[]{i, j});
            }
        }
        int solve = solve(jihoon);


        System.out.println(solve < 0 ? "IMPOSSIBLE" : solve);
    }

    public static int solve(int[] jihoon) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        boolean[][] visited = new boolean[R][C];
        visited[jihoon[0]][jihoon[1]] = true;
        queue.offer(jihoon);

        int time = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            fire();
            time++;
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int dr = pos[0] + delta[d][0];
                    int dc = pos[1] + delta[d][1];
                    if (dr < 0 || dc < 0 || dr >= R || dc >= C) return time - 1;

                    if (map[dr][dc] == '.' && !visited[dr][dc]) {
                        queue.offer(new int[]{dr, dc});
                        visited[dr][dc] = true;
                    }
                }
            }
        }
        return -1;

    }

    public static void fire() {
        int size = fireQ.size();
        for (int i = 0; i < size; i++) {
            int[] pos = fireQ.poll();
            for (int d = 0; d < 4; d++) {
                int dr = pos[0] + delta[d][0];
                int dc = pos[1] + delta[d][1];
                if (dr < 0 || dc < 0 || dr >= R || dc >= C) continue;
                if (map[dr][dc] == '#'||map[dr][dc]=='F') continue;
                map[dr][dc] = 'F';
                fireQ.offer(new int[]{dr, dc});
            }
        }
    }


}
