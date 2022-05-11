package backjun.단계10브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 분해합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int length = String.valueOf(n).length();

        for (int i = 1; i <= n - length; ++i) {
            int value = i;
            int temp = i;
            for (int k = 0; k < length; ++k) {
                value += temp % 10;
                temp /= 10;
            }
            if(value==n){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);


    }
}
