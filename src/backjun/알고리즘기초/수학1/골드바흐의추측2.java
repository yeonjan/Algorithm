package backjun.알고리즘기초.수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class 골드바흐의추측2 {
    static boolean[] isPrime;
    static ArrayList<Integer> primes = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        getPrime();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;


            for (int i = 2; i <= n / 2; i++) {
                int a = i;
                int b = n - i;
                if (isPrime[a] && isPrime[b]) {
                    sb.append(n + " = " + a + " + " + b).append("\n");
                    break;
                }
            }

        }
        System.out.println(sb);
    }

    public static void getPrime() {
        isPrime = new boolean[1000001];

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= 1000000; i++) {
            if (!isPrime[i]) continue;

            for (int k = (i * 2); k <= 1000000; k += i) {
                isPrime[k] = false;
            }
        }
    }
}
