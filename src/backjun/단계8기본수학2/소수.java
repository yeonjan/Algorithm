package backjun.단계8기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int min = 0;
        for (int i = m; i <= n; ++i) {
            if (isPrime(i)) {
                if (sum == 0) min = i;
                sum += i;
            }
        }
        if(sum!=0){
            sb.append(sum).append("\n").append(min);
        }else sb.append(-1);
        System.out.println(sb);
    }

    public static boolean isPrime(int num) {
        if (num == 1) return false;

        for (int i = 2; i < num; ++i) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
