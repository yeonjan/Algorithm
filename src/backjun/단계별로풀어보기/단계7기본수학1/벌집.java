package backjun.단계별로풀어보기.단계7기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2-7,8-19,20-37...
public class 벌집 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        int i = 1;
        int range = 1;
        if (input == 1) {
            System.out.println(1);
        } else {
            while (input > range) {
                range += 6 * i;
                i++;
            }
            System.out.println(i);
        }
    }
}
