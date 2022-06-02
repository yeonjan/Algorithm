package backjun.단계별로풀어보기.단계4배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평균은넘겠지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int testCase = 0; testCase < c; ++testCase) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int sum = 0;
            int count = 0;

            int[] score = new int[n];
            for (int i = 0; i < n; ++i) {
                score[i] = Integer.parseInt(st.nextToken());
                sum += score[i];
            }
            for (int s : score) {
                if (s > sum / n) count++;
            }
            sb.append(String.format("%.3f%%\n", (double) count * 100 / n));
        }

        System.out.println(sb.toString());

    }
}
