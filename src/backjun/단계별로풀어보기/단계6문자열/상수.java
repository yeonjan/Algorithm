package backjun.단계별로풀어보기.단계6문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        sb.append(st.nextToken()).append(" ");
        sb.append(st.nextToken());

        String[] number = sb.reverse().toString().split(" ");

        int A = Integer.parseInt(number[1]);
        int B = Integer.parseInt(number[0]);

        if (A > B) {
            System.out.println(A);
        } else System.out.println(B);
    }
}
