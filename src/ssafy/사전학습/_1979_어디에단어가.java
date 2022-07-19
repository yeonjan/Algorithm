package ssafy.사전학습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1979_어디에단어가 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(br.readLine());

        for (int t = 1; t <= test; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            //puzzle 생성
            String[][] puzzle = new String[n][n];
            for (int i = 0; i < n; i++) {
                puzzle[i] = br.readLine().split(" ");
            }

            int total = 0;
            for (int h = 0; h < n; h++) {
                int cnt1 = 0;
                int cnt2 = 0;
                for (int w = 0; w < n; w++) {
                    if (puzzle[h][w].equals("1")) {
                        cnt1++;
                    } else {
                        if (cnt1 == k) {
                            total++;
                        }
                        cnt1 = 0;
                    }

                    if (puzzle[w][h].equals("1")) {
                        cnt2++;
                    } else {
                        if (cnt2 == k) {
                            total++;
                        }
                        cnt2 = 0;
                    }
                }

                if (cnt1 == k) total++;
                if (cnt2 == k) total++;
            }

            sb.append("#" + t + " " + total + "\n");
        }
        System.out.println(sb);
    }
}
