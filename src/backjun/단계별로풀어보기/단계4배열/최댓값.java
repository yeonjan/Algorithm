package backjun.단계별로풀어보기.단계4배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 최댓값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] values = new int[9];
        int max = 0;
        int index = 0;
        for (int i = 0; i < 9; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < 9; i++) {
            if (max < values[i]) {
                max = values[i];
                index = i + 1;
            }
        }

        System.out.println(max);
        System.out.println(index);
    }
}
