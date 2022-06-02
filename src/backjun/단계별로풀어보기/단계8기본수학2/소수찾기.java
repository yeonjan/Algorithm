package backjun.단계별로풀어보기.단계8기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 0; i < N; ++i) {
            int num = Integer.parseInt(st.nextToken());
            if (isPrime(num)) cnt++;
        }
        System.out.println(cnt);

    }

    public static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i < num; ++i) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
