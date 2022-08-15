package ssafy.수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5215_햄버거다이어트_정연진 {
    static int L, N, answer;
    static int[][] ingredient;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            ingredient = new int[N][2];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                ingredient[i][0] = Integer.parseInt(st.nextToken());
                ingredient[i][1] = Integer.parseInt(st.nextToken());
            }

            comb(0, 0, 0);


            sb.append("#" + t + " " + answer).append("\n");
        }
        System.out.println(sb);
    }

    public static void comb(int depth, int cal, int score) {
        if (cal > L) return;

        answer = Math.max(answer, score);

        if (depth == N) return;

        comb(depth + 1, cal, score);
        comb(depth + 1, cal + ingredient[depth][1], score + ingredient[depth][0]);


    }
}
