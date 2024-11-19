import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int R, C;
    static int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static char[][] map;
    static boolean[][] visited;
    static boolean[][] visitedSearch;
    static Queue<int[]> waterQ = new ArrayDeque<>();
    static Queue<int[]> swanQ = new ArrayDeque<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        visitedSearch = new boolean[R][C];

        int cnt = 0;
        for (int i = 0; i < R; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {

                map[i][j] = input[j];
                if (map[i][j] == '.') {
                    waterQ.add(new int[]{i, j});
                    visited[i][j] = true;
                } else if (map[i][j] == 'L') {
                    if (cnt == 0) {
                        swanQ.add(new int[]{i, j});
                        visitedSearch[i][j] = true;
                    }
                    waterQ.add(new int[]{i, j});
                    visited[i][j] = true;
                    cnt++;
                }
            }
        }

        int day = 0;
        while (!swanQ.isEmpty()) {
            if (day != 0) {
                findIce();
            }

            //백조 만나는지 확인
            if (findSwan()) {
                break;
            }
            day++;
        }
        System.out.println(day);


    }

    public static void findIce() {
        Queue<int[]> temp = new ArrayDeque<>();
        while (!waterQ.isEmpty()) {
            int[] cur = waterQ.poll();
            for (int d = 0; d < 4; d++) {
                int dr = cur[0] + delta[d][0];
                int dc = cur[1] + delta[d][1];
                if (dr < 0 || dc < 0 || dr >= R || dc >= C) continue;

                if (!visited[dr][dc]) {
                    if (map[dr][dc] == 'X') {
                        temp.add(new int[]{dr, dc});
                    } else {
                        waterQ.offer(new int[]{dr, dc});
                    }
                    visited[dr][dc] = true;
                }


            }
        }
        //얼음 녹이기
        while (!temp.isEmpty()) {
            int[] cur = temp.poll();
            waterQ.add(cur);
            map[cur[0]][cur[1]] = '.';

        }
    } 

    public static boolean findSwan() {
        Queue<int[]> temp = new ArrayDeque<>();
        while (!swanQ.isEmpty()) {
            int[] cur = swanQ.poll();
            for (int d = 0; d < 4; d++) {
                int dr = cur[0] + delta[d][0];
                int dc = cur[1] + delta[d][1];
                if (dr < 0 || dc < 0 || dr >= R || dc >= C) continue;

                if (!visitedSearch[dr][dc]) {
                    if (map[dr][dc] == '.') {
                        swanQ.add(new int[]{dr, dc});
                    } else if (map[dr][dc] == 'X') {
                        temp.add(new int[]{dr, dc});
                    } else {
                        return true;
                    }
                    visitedSearch[dr][dc] = true;

                }

            }
        }
        while (!temp.isEmpty()) {
            swanQ.add(temp.poll());
        }
        return false;
    }
}
