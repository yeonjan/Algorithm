package backjun.단계별로풀어보기.단계3for;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_25304_영수증 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int sum = 0;

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            sum += Integer.parseInt(input[0]) * Integer.parseInt(input[1]);
        }
        System.out.println(sum==x?"Yes":"No");
    }
}
