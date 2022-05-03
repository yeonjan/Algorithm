package backjun.단계8기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.sqrt;

public class 소인수분해 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 2; i <= sqrt(n); i++) {
            while (n % i == 0) {
                sb.append(i).append("\n");
                n /= i;
            }
        }
        if(n!=1){
            sb.append(n);
        }
        System.out.println(sb);

    }
}
