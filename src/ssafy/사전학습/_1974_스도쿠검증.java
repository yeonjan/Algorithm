package ssafy.사전학습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1974_스도쿠검증 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test = Integer.parseInt(br.readLine());

        for (int t = 1; t <= test; t++) {
            int[][] input = new int[9][9];
            boolean[] exists_row = new boolean[10];
            boolean[] exists_col = new boolean[10];
            int result = 1;

            //Input 배열 생성
            for (int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    input[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            for (int h = 0; h < 9; h++) {
                for (int w = 0; w < 9; w++) {
                    //가로
                    if (!exists_row[input[h][w]]) exists_row[input[h][w]] = true;
                    else {
                        result = 0;
                        break;
                    }
                    //세로
                    if (!exists_col[input[w][h]]) exists_col[input[w][h]] = true;
                    else {
                        result = 0;
                        break;
                    }
                }
                Arrays.fill(exists_row, false);
                Arrays.fill(exists_col, false);
            }

            for (int move = 0; move < 9; move += 3) {
                for (int i = move; i < move + 3; i++) {
                    for (int j = move; j < move + 3; j++) {
                        if (!exists_row[input[i][j]]) exists_row[input[i][j]] = true;
                        else {
                            result = 0;
                            break;
                        }
                    }
                }
                Arrays.fill(exists_row, false);

            }

            sb.append("#" + t + " " + result + "\n");

        }
        System.out.println(sb);
    }
}
