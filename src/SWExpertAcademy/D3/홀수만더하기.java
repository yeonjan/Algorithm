package SWExpertAcademy.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 홀수만더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int sum;
        int value;
        for (int i = 0; i < T; i++) {
            sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                value = Integer.parseInt(st.nextToken());
                if (value % 2 == 1) {
                    sum += value;
                }
            }
            System.out.println(String.format("#%d %d", i + 1, sum));
        }
    }
}
