package backjun.단계4배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 나머지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] rests = new int[42];
        int count = 0;

        for (int i = 0; i < 10; i++) {
            int input = Integer.parseInt(br.readLine());
            int rest = input % 42;
            if (rests[rest]==0) {
                rests[rest] = 1;
                count++;
            }
        }

        System.out.println(count);

    }
}
