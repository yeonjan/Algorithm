package backjun.단계6문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] num = br.readLine().toCharArray();

        int sum = 0;

        for (char n : num) {
            sum += n -'0'; //ASCII 이용 '0'==48, 숫자 'n' == 48+n
        }
        System.out.println(sum);
    }
}
