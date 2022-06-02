package backjun.단계별로풀어보기.단계8기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.sqrt;

public class 소수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        boolean[] check = new boolean[n + 1];
        check[0] = true;
        check[1] = true;

        for (int i = 2; i <= sqrt(n); ++i) {
            if (check[i]) continue;

            if (i >= m) sb.append(i).append("\n");

            for (int k = i * i; k <= n; k += i) {
                check[k] = true;
            }
        }

        for (int i = m; i <= n; ++i) {
            if (!check[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
