package backjun.단계5함수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 한수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 1; i < N + 1; ++i) {
            if (is_hansoo(i)) count++;
        }
        System.out.println(count);
    }

    static boolean is_hansoo(int n) {
        int length = Integer.toString(n).length();
        int[] arr = new int[length];

        for (int i = 0; i < length; ++i) {
            arr[i] = n % 10;
            n = n / 10;
        }
        if (length > 2) {
            int d1 = arr[0] - arr[1];
            for (int i = 1; i < length - 1; ++i) {
                int d2 = arr[i] - arr[i + 1];
                if (d1 != d2) return false;
            }
        }

        return true;
    }
}
