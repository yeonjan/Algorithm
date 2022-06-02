package backjun.단계별로풀어보기.단계7기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부녀회장1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; ++i) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            System.out.println(howMany(k, n));
        }
    }
    public static int howMany(int k, int n) {
        int people = 0;
        if (k == 0) {
            return n;
        } else {
            for (int i = 1; i <= n; i++) {
            people += howMany(k-1,i);
            }
            return people;
        }
    }
}
