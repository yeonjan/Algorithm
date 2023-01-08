package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_21609_상어중학교 {
    static int m, n, score;
    static int[][] map, roundMap;
    static List<Group> list = new ArrayList<>();
    static int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static class Group {
        int num, r, c, color, rainbowCnt, cnt;

        public Group(int num, int r, int c, int color, int cnt, int rainbowCnt) {
            this.num = num;
            this.r = r;
            this.c = c;
            this.color = color;
            this.rainbowCnt = rainbowCnt;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        while (true) {
            list.clear();
            int num = 1;
            roundMap = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > 0 && roundMap[i][j] == 0) {
                        findBlock(new Group(num++, i, j, map[i][j], 1, 0));
                    }
                }
            }
            if (list.size() == 0) break;
            list.sort((o1, o2) -> {
                if (o1.cnt == o2.cnt) {
                    if (o1.rainbowCnt == o2.rainbowCnt) {
                        if (o1.r == o2.r) return Integer.compare(o2.c, o1.c);
                        return Integer.compare(o2.r, o1.r);
                    }
                    return Integer.compare(o2.rainbowCnt, o1.rainbowCnt);
                }
                return Integer.compare(o2.cnt, o1.cnt);
            });

            if (list.get(0).cnt<2) break;

            Group sBlock = list.get(0);
            score += Math.pow(sBlock.cnt, 2);
            removeBlock(sBlock);
            gravity();
            rotate();
            gravity();

        }

        System.out.println(score);

    }

    public static void findBlock(Group group) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];

        queue.offer(new int[]{group.r, group.c});
        visited[group.r][group.c] = true;
        roundMap[group.r][group.c] = group.num;
        int color = group.color;


        while (!queue.isEmpty()) {
            int[] block = queue.poll();

            for (int i = 0; i < 4; i++) {
                int dr = block[0] + delta[i][0];
                int dc = block[1] + delta[i][1];

                if (!check(dr, dc)) continue;
                if ((map[dr][dc] != 0 && map[dr][dc] != color) || map[dr][dc] == -1) continue;

                if (!visited[dr][dc]) {
                    visited[dr][dc] = true;
                    if (map[dr][dc] != 0) roundMap[dr][dc] = group.num;
                    queue.offer(new int[]{dr, dc});
                    group.cnt++;
                    if (map[dr][dc] == 0) {
                        group.rainbowCnt++;
                    }

                }
            }
        }

        list.add(group);
    }

    public static void removeBlock(Group group) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];

        queue.offer(new int[]{group.r, group.c});
        visited[group.r][group.c] = true;
        int color = group.color;

        while (!queue.isEmpty()) {
            int[] block = queue.poll();
            map[block[0]][block[1]] = -2;

            for (int i = 0; i < 4; i++) {
                int dr = block[0] + delta[i][0];
                int dc = block[1] + delta[i][1];

                if (!check(dr, dc)) continue;
                if ((map[dr][dc] != 0 && map[dr][dc] != color) || map[dr][dc] == -1) continue;

                if (!visited[dr][dc]) {
                    visited[dr][dc] = true;
                    queue.offer(new int[]{dr, dc});
                }
            }
        }
    }

    public static void gravity() {
        for (int c = 0; c < n; c++) {
            boolean isStart = false;
            int inputR = -1;
            for (int r = n - 1; r >= 0; r--) {
                if (map[r][c] == -1) {
                    isStart = false;
                    continue;
                }
                if (!isStart && map[r][c] == -2) {
                    inputR = r;
                    isStart = true;
                    continue;
                }

                if (isStart && map[r][c] >= 0) {
                    map[inputR][c] = map[r][c];
                    map[r][c] = -2;
                    inputR--;
                }
            }

        }
    }

    public static void rotate() {
        int[][] map2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            map2[i] = map[i].clone();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[n - 1 - j][i] = map2[i][j];
            }
        }
    }

    public static boolean check(int dr, int dc) {
        return dr >= 0 && dc >= 0 && dr < n && dc < n;
    }
}
//기준 블록 -> 행이 가장 작고, 열이 가장 작은
//점수획득 -> 1. 가장 많은 블록 2. 무지개 블록이 많은거 3. 기준 블록 행이 큰것 4. 기준 블록 열이 큰것

//1. 블록 그룹 찾기 -> bfs
//2. 점수 반영
//3. 중력 -> 90도 반시계 회전 -> 중력