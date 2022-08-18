package study.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main_7576_토마토 {
    static int M, N, day, tomatoCnt;
    static int[][] box;
    static Queue<Tomato> queue = new LinkedList<>();
    static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static boolean isChange = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) queue.offer(new Tomato(i, j));
                else if (box[i][j] == 0) tomatoCnt++;
            }
        }

        BFS();
        System.out.println(day);

    }

    public static void BFS() {
        while (tomatoCnt > 0) {
            if (!isChange) {
                day = -1;
                return;
            }
            int size = queue.size();
            day++;
            isChange = false;
            while (size-- > 0) {
                Tomato tom = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int r = tom.r + delta[i][0];
                    int c = tom.c + delta[i][1];
                    if (r >= 0 && r < N && c >= 0 && c < M && box[r][c] == 0) {
                        queue.offer(new Tomato(r, c));
                        box[r][c] = 1;
                        tomatoCnt--;
                        isChange = true;
                    }
                }
            }
        }
    }

}

class Tomato {
    int r;
    int c;

    public Tomato(int r, int c) {
        this.r = r;
        this.c = c;

    }
}

