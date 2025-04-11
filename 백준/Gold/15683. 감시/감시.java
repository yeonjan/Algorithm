import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N, M;
    static int[][] map;
    static int[][] delta = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    static int ans = Integer.MAX_VALUE;
    static int area = 0;

    static class CCTV {
        int r;
        int c;
        int type;
        int[][] rotate;

        public CCTV(int r, int c, int type) {
            this.r = r;
            this.c = c;
            this.type = type;

            if (type == 1) this.rotate = new int[][]{{0}, {1}, {2}, {3}};
            else if (type == 2) this.rotate = new int[][]{{0, 2}, {1, 3}};
            else if (type == 3) this.rotate = new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 0}};
            else if (type == 4) this.rotate = new int[][]{{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}};
            else this.rotate = new int[][]{{0, 1, 2, 3}};
        }

        private int getDirectionCnt() {
            return this.rotate.length;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        List<CCTV> cctv = new ArrayList<>(); // r,c,type

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0 && map[i][j] < 6) cctv.add(new CCTV(i, j, map[i][j]));
                if (map[i][j] == 0) area++;
            }
        }

        dfs(0, cctv, new int[cctv.size()]);
        System.out.println(ans);


    }


    public static void dfs(int idx, List<CCTV> cctvList, int[] direction) {
        if (idx >= cctvList.size()) {
            int cntOnCCTV = onCctv(cctvList, direction);
            ans = Math.min(ans, area - cntOnCCTV);
            return;
        }


        for (int d = 0; d < cctvList.get(idx).getDirectionCnt(); d++) {
            direction[idx] = d;
            dfs(idx + 1, cctvList, direction);
        }


    }

    public static int onCctv(List<CCTV> cctvList, int[] direction) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        int cnt = 0;
        for (int i = 0; i < cctvList.size(); i++) {
            CCTV cctv = cctvList.get(i);
            int direct = direction[i];
            for (int d : cctv.rotate[direct]) {
                int r = cctv.r;
                int c = cctv.c;
                while (true) {
                    r += delta[d][0];
                    c += delta[d][1];
                    //더이상 갈 수 없는 경우
                    if (r < 0 || c < 0 || r >= N || c >= M) break;
                    if (map[r][c] == 6) break;
                    //다른 cctv인 경우
                    if (map[r][c] != 0) continue;

                    if (!visited[r][c]) {
                        visited[r][c] = true;
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

}
