package backjun.단계별로풀어보기.단계4배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최소최대 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[N];
        int max;
        int min;

        for (int i = 0; i < N; ++i) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        max = input[0];
        min = input[0];


        for (int i = 0; i < N; ++i) {
            if (max < input[i]) {
                max = input[i];
            }
            if (min > input[i]) {
                min = input[i];
            }
        }
        System.out.println(min + " " + max);
    }
}
