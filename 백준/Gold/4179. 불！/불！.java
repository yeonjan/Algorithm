import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int R, C;
    static String[][] map;
    static int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new String[R][C];
        int[] start = new int[2];
        Queue<int[]> fireQ = new ArrayDeque<>();
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                if (map[i][j].equals("J")) {
                    start = new int[]{i, j};
                    map[i][j] = ".";
                }
                if (map[i][j].equals("F")) {
                    fireQ.add(new int[]{i, j});
                }

            }
        }
        bfs(start, fireQ);
        System.out.println();


    }

    public static void bfs(int[] start, Queue<int[]> fireList) {
        Queue<int[]> queue = new ArrayDeque<>(); // r,c,time
        boolean[][] visited = new boolean[R][C];
        int escapeTime = -1;
        int time = 0;
        queue.add(new int[]{start[0], start[1]});
        visited[start[0]][start[1]] = true;

        Escape:
        while (!queue.isEmpty()) {
            time++;
            fire(fireList);

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] jihun = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int dr = jihun[0] + delta[d][0];
                    int dc = jihun[1] + delta[d][1];

                    if (dr < 0 || dc < 0 || dr >= R || dc >= C) {
                        escapeTime = time;
                        break Escape;
                    }
                    if (map[dr][dc].equals(".") && !visited[dr][dc]) {
                        queue.add(new int[]{dr, dc});
                        visited[dr][dc] = true;
                    }
                }

            }

        }

        System.out.println(escapeTime != -1 ? escapeTime : "IMPOSSIBLE");


    }

    public static void fire(Queue<int[]> fireQueue) {
        int size = fireQueue.size();
        for (int i = 0; i < size; i++) {
            int[] fire = fireQueue.poll();
            for (int d = 0; d < 4; d++) {
                int dr = fire[0] + delta[d][0];
                int dc = fire[1] + delta[d][1];
                if (dr < 0 || dc < 0 || dr >= R || dc >= C) continue;
                if (map[dr][dc].equals(".")) {
                    map[dr][dc] = "F";
                    fireQueue.add(new int[]{dr, dc});
                }
            }


        }


    }


}
