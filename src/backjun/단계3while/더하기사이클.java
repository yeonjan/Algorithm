package backjun.단계3while;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 더하기사이클 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cycle = 0;
        int value = N;

        while (value != N || cycle == 0) {
            int tens = value / 10;
            int units = value % 10;
            int sum = tens + units;

            value = (units * 10) + (sum % 10);
            cycle ++;
        }
        System.out.println(cycle);

    }
}
