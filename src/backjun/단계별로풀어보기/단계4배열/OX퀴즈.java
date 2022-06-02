package backjun.단계별로풀어보기.단계4배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OX퀴즈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; ++i) {
            int score = 0;
            int sum = 0;
            char[] quiz = br.readLine().toCharArray();
            for (char result : quiz) {
                if (result == 'O') {
                    score++;
                } else score = 0;
                sum+=score;
            }
            System.out.println(sum);
        }
    }
}
