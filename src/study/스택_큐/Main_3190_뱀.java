package study.스택_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_3190_뱀 {
    static int N, K, L, time;
    static boolean[][] apple, S;
    static int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//좌하우상

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        LinkedList<int[]> snake = new LinkedList<>();
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        apple = new boolean[N][N];
        S = new boolean[N][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            apple[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = true;
        }

        L = Integer.parseInt(br.readLine());
        snake.offer(new int[]{0, 0});
        int d = 0;
        boolean end = false;
        END:
        for (int l = 0; l < L; l++) {
            st = new StringTokenizer(br.readLine());
            int move = Integer.parseInt(st.nextToken()) - time;
            String LR = st.nextToken();

            for (int i = 0; i < move; i++) {
                if (!move(snake, d)) {
                    end = true;
                    break END;
                }
            }
            d = changeDirect(d, LR);
        }
        while (!end && move(snake, d)) {

        }


        System.out.println(time);

    }

    public static int changeDirect(int now, String LR) {
        if (LR.equals("L")) now--;
        else if (LR.equals("D")) now++;

        if (now == 4) now = 0;
        else if (now == -1) now = 3;

        return now;
    }

    public static boolean move(LinkedList<int[]> snake, int d) {
        time++;
        int[] cur = snake.peekLast();
        int[] head = new int[2];
        head[0] = cur[0] + delta[d][0];
        head[1] = cur[1] + delta[d][1];

        //벽에 부딪히면 게임 종료 || 자기자신과 부딪히면 게임 종료
        if (head[0] < 0 || head[0] >= N || head[1] < 0 || head[1] >= N || S[head[0]][head[1]]) {
            return false;
        }

        snake.offer(head);
        S[head[0]][head[1]] = true;

        if (!apple[head[0]][head[1]]) {
            int[] out = snake.poll();
            S[out[0]][out[1]] = false;
        } else apple[head[0]][head[1]] = false;

        return true;
    }
}
