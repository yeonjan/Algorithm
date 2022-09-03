package study.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_14502_연구소 {
    static int N, M, ans, blank;
    static int[][] map, selected = new int[3][2], delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static List<int[]> virus = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        // 연구소 정보 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                //바이러스는 virus 리스트에 저장
                if (map[i][j] == 2) virus.add(new int[]{i, j});

                //이후 안전영역 확인을 위해 빈칸 카운트
                if (map[i][j] == 0) blank++;
            }
        }
        comb(0, 0);
        System.out.println(ans);
    }

    public static void comb(int cnt, int start) {
        //벽을 세울 빈칸 3개를 선택한 경우
        if (cnt == 3) {
            //바이러스 퍼뜨리기 & 안전영역 크기 구하기
            int safe = bfs();
            ans = Math.max(ans, safe);
            return;
        }

        for (int i = start; i < N * M; i++) {
            int r = i / M;
            int c = i % M;
            //빈칸이라면 선택
            if (map[r][c] == 0) {
                selected[cnt] = new int[]{r, c};
                comb(cnt + 1, i + 1);
            }
        }
    }

    public static int bfs() {
        int cnt = 0; //새롭게 퍼진 바이러스의 수

        LinkedList<int[]> queue = new LinkedList<>();
        int[][] map2 = new int[N][M];

        //연구소 맵 복사
        for (int i = 0; i < N; i++) {
            map2[i] = map[i].clone();
        }

        //선택한 빈칸에 벽 세우기
        for (int[] s : selected) {
            map2[s[0]][s[1]] = 1;
        }

        //초기 바이러스 큐에 넣기
        for (int[] v : virus) {
            queue.offer(v);
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int dr = poll[0] + delta[i][0];
                int dc = poll[1] + delta[i][1];
                if (dr < 0 || dr >= N || dc < 0 || dc >= M) continue;

                //바이러스 퍼뜨리기
                if (map2[dr][dc] == 0) {
                    cnt++;
                    map2[dr][dc] = 2;
                    queue.offer(new int[]{dr, dc});
                }
            }
        }

        // 원래 빈칸 - 새롭게 발생한 바이러스 - 벽3개
        return blank - cnt - 3;
    }
}