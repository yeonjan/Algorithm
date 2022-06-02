package backjun.단계별로풀어보기.단계6문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 크로아티아알파벳 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] croatia = {"c=", "c-", "d-", "dz=", "lj", "nj", "s=", "z="};

        String input = br.readLine();

        for (String c : croatia) {
            input = input.replaceAll(c, "*");
        }

        System.out.println(input.length());
    }
}
