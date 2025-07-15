import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int ans = 0;

    public static class MapInfo {
        int[][] map;
        int N, M;
        int safeArea;

        public MapInfo(int[][] map, int N, int M) {
            this.map = map;
            this.N = N;
            this.M = M;
            setSafeArea();

        }

        private void setSafeArea() {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) {
                        safeArea++;
                    }
                }
            }
        }

        public void createWall(int[] pos) {
            for (int p : pos) {
                map[p / M][p % M] = 3;
            }
            safeArea-=pos.length;
        }

        public void deleteWall(int[] pos) {
            for (int p : pos) {
                map[p / M][p % M] = 0;
            }
            safeArea+=pos.length;
        }

        public int getSafeArea() {
            int safe = this.safeArea;
            boolean[][] visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 2) {
                        int virus = countVirus(visited, i, j);
                        safe -= virus;
                    }
                }
            }
            return safe;
        }

        private int countVirus(boolean[][] visited, int r, int c) {
            ArrayDeque<int[]> queue = new ArrayDeque<>();
            int[][] delta = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
            visited[r][c] = true;
            queue.add(new int[]{r, c});
            int cnt = -1;

            while (!queue.isEmpty()) {
                cnt++;
                int[] pos = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int dr = pos[0] + delta[d][0];
                    int dc = pos[1] + delta[d][1];
                    if (dr < 0 || dc < 0 || dr >= N || dc >= M) continue;

                    if (!visited[dr][dc] && map[dr][dc] == 0) {
                        visited[dr][dc] = true;
                        queue.offer(new int[]{dr, dc});
                    }
                }
            }
            return cnt;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        MapInfo mapInfo = new MapInfo(map, N, M);

        dfs(mapInfo, new int[3], 0, 0);
        System.out.println(ans);

    }

    public static void dfs(MapInfo mapInfo, int[] pos, int idx, int num) {
        if (idx == 3) {
//            System.out.println(pos[0] + " " + pos[1] + " " + pos[2]);
            mapInfo.createWall(pos);
            int safeArea = mapInfo.getSafeArea();

            if(ans<safeArea){
                ans=safeArea;
            }

            mapInfo.deleteWall(pos);
            return;
        }
        for (int i = num; i < mapInfo.N * mapInfo.M; i++) {
            if (mapInfo.map[i / mapInfo.M][i % mapInfo.M] == 0) {
                pos[idx] = i;
                dfs(mapInfo, pos, idx + 1, i + 1);
            }
        }

    }


}