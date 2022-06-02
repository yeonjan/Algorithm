package backjun.단계별로풀어보기.단계9재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치수5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(fibonacci(n));
    }
    public static int fibonacci(int n) {
        if(n==0) return 0;
        if(n==1) return 1;

        return fibonacci(n-1)+fibonacci(n-2);
    }
}
