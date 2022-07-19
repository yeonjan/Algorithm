package ssafy.사전학습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1959_두개의숫자열 {
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            String[] a = br.readLine().split(" ");
            String[] b = br.readLine().split(" ");

            result = 0;
            if (n <= m) {
                calculate(m - n, b, a);
            } else {
                calculate(n - m, a, b);
            }

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    public static void calculate(int moveSize, String[] bigger, String[] smaller) {
        for (int i = 0; i < moveSize + 1; i++) {
            int total = 0;
            for (int j = 0; j < smaller.length; j++) {
                total += Integer.parseInt(bigger[i + j]) * Integer.parseInt(smaller[j]);
            }
            result = Math.max(total, result);
        }
    }
}
