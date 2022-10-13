package ssafy.과제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5607_조합 {
    static int n, r, mod = 1234567891;
    static long[] factorial;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int T = 1; T <= t; T++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            factorial = new long[n + 1];
            factorial[0] = 1;
            for (int i = 1; i <= n; i++) {
                factorial[i] = (i * factorial[i - 1]) % mod;
            }

            long a = (factorial[r] * factorial[n - r])% mod;
            sb.append("#" + T + " " + (factorial[n] * pow(a, mod - 2)) % mod).append("\n");
        }
        System.out.println(sb);

    }

    public static long pow(long a, long b) {
        if (b == 1) return a;

        long num = pow(a, b / 2);
        long num2 = (num * num) % 1234567891;

        if (b % 2 == 0) {
            return num2;
        } else {
            return (a * num2) % 1234567891;
        }
    }

}
