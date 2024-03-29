package study.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_2573_빙산 {
    static int N, M, cnt, icebergCnt, year;
    static int[][] map;
    static boolean[][] isIceberg, visit;
    static int[] deltaX = {0, 1, 0, -1};
    static int[] deltaY = {-1, 0, 1, 0};

    static class Point {
        int x;
        int y;

        public Point(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isIceberg = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    isIceberg[i][j] = true;
                    icebergCnt++;
                }
            }
        }

        //빙산의 수가 다 녹을 때 까지 진행
        boolean isDivided = false;
        while (icebergCnt > 0) {

            oneYearLater();

            //bfs를 이용해 분리 되었는지 확인
            cnt = 0; //덩어리의 수
            visit = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (isIceberg[i][j] && !visit[i][j]) {
                        bfs(new Point(i, j));
                    }
                }
            }
            //덩어리가 두개 이상이면 반복을 종료
            if (cnt > 1) {
                isDivided = true;
                break;
            }
        }
        System.out.println(isDivided ? year : 0);

    }

    public static void bfs(Point startP) {
        LinkedList<Point> queue = new LinkedList<>();
        queue.offer(startP);
        cnt++;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            //연결된 빙산이 있는지 탐색
            for (int i = 0; i < 4; i++) {
                int dx = point.x + deltaX[i];
                int dy = point.y + deltaY[i];
                if (dx >= 0 && dx < M && dy >= 0 && dy < N && isIceberg[dy][dx] && !visit[dy][dx]) {
                    visit[dy][dx] = true;
                    queue.offer(new Point(dy, dx));
                }
            }

        }


    }

    public static void oneYearLater() {
        year++;
        //빙산이면 인접한 바다의 수 만큼 높이 줄이기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (isIceberg[i][j]) {
                    map[i][j] -= countSea(i, j);
                }
            }
        }
        //녹은 빙산 체크
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] <= 0 && isIceberg[i][j]) {
                    map[i][j] = 0;
                    isIceberg[i][j] = false;
                    icebergCnt--;
                }
            }
        }
    }

   //인접한 바다의 수 계산
    public static int countSea(int y, int x) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int dx = x + deltaX[i];
            int dy = y + deltaY[i];
            if (dx >= 0 && dx < M && dy >= 0 && dy < N && !isIceberg[dy][dx]) cnt++;
        }
        return cnt;
    }
}

