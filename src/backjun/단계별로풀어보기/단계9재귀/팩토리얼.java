package backjun.단계별로풀어보기.단계9재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팩토리얼 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(factorial(n));
    }

    public static int factorial(int n) {
        if (n <= 1) return 1;
        else {
            return n * factorial(n-1);
        }

    }
}
