package backjun.단계8기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.sqrt;

public class 골드바흐의추측 {

    static boolean[] prime = new boolean[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; ++i) {
            int n = Integer.parseInt(br.readLine());
            isPrime(n);
            for (int k = 0; k <= n / 2; ++k) {
                int num1 = n / 2 - k;
                int num2 = n / 2 + k;
                if (!prime[num1] && !prime[num2]) {
                    sb.append(num1).append(" ").append(num2).append("\n");
                    break;
                }
            }

        }
        System.out.println(sb);
    }

    public static void isPrime(int n) {
        prime[0] = prime[1] = true;

        for (int i = 2; i <= sqrt(n); ++i) {
            if (prime[i]) continue;
            for (int k = 2 * i; k <= n; k += i) {
                prime[k] = true;
            }
        }
    }
}
