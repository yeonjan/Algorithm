package backjun.단계별로풀어보기.단계6문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 다이얼 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int time = 0;

        for (int i = 0; i < word.length(); ++i) {
            char alphabet = word.charAt(i);
            if (alphabet < 'P') {
                time += (alphabet - 'A') / 3 + 3;
            } else if (alphabet < 'T') {
                time += 8;
            } else if (alphabet < 'W') {
                time += 9;
            } else {
                time += 10;
            }
        }
        System.out.println(time);

    }
}
