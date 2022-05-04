package backjun.단계8기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.sqrt;

public class 베르트랑공준 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            sb.append(countPrime(n)).append("\n");
        }
        System.out.println(sb);

    }

    public static int countPrime(int n) {
        boolean[] num = new boolean[2 * n + 1];
        num[0] = num[1] = true;
        int cnt = 0;

        for (int i = 2; i <= sqrt(2 * n); ++i) {
            if (num[i]) continue;

            for (int k = i * i; k <= 2 * n; k += i) {
                num[k] = true;
            }
        }
        for (int i = n+1; i <= 2 * n; ++i) {
            if(!num[i]) cnt++;
        }

        return cnt;
    }
}
