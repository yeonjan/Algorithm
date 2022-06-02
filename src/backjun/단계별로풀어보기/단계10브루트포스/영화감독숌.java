package backjun.단계별로풀어보기.단계10브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 영화감독숌 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 665;

        while (n > 0) {
            result++;
            if (String.valueOf(result).contains("666")) n--;
        }

        System.out.println(result);
    }
}
