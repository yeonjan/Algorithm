package backjun.단계별로풀어보기.단계10브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 체스판다시칠하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] board = new String[n];
        for (int i = 0; i < n; ++i) {
            board[i] = br.readLine();
        }

        int black = getMin(board, n, m, 'W', 'B');
        int white = getMin(board, n, m, 'B', 'W');

        System.out.println(Math.min(black, white));
    }

    public static int getMin(String[] board, int n, int m, char chess1, char chess2) {
        int min = 2500;
        char prev1, prev2;
        for (int h = 0; h < n - 7; h++) {
            for (int w = 0; w < m - 7; w++) {
                int change = 0;
                prev1 = chess1;
                prev2 = chess2;
                for (int i = h; i < h + 8; ++i) {
                    for (int k = w; k < w + 8; ++k) {
                        char now = board[i].charAt(k);
                        if (now == prev1) {
                            change++;
                            prev1 = prev2;
                            prev2 = now;
                        } else {
                            prev2 = prev1;
                            prev1 = now;
                        }
                    }
                    char temp = prev1;
                    prev1 = prev2;
                    prev2 = temp;
                }
                min = Math.min(change, min);
            }
        }
        return min;
    }
}

