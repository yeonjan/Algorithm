package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2885_초콜릿식사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int d = 1;
        int cnt = 0;

        for (int i = 0; i < 20; i++) {
            if (d >= k) break;
            d *= 2;
        }

        if (d != k) cnt = count(d, k);

        System.out.println(d + " " + cnt);
    }

    public static int count(int d, int k) {
        int cnt = 0;
        while (d > 0) {
            if (k == 0) break;
            d /= 2;
            if (d <= k) k -= d;
            cnt++;
        }
        return cnt;
    }
}
