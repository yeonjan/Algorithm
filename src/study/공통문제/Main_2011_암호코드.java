package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2011_암호코드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] code = br.readLine().toCharArray();

        int size = code.length;
        long[] dp = new long[size + 1];


        dp[0] = 1;
        if ((code[0] - '0') != 0) dp[1] = 1;
        for (int i = 2; i <= size; i++) {
            int codePre = (code[i - 2] - '0') * 10;
            int codeNow = (code[i - 1] - '0');

            if (codeNow != 0) dp[i] += dp[i - 1];
            if (codePre != 0 && codePre + codeNow <= 26) dp[i] += dp[i - 2];
            dp[i] %= 1000000;
        }

        System.out.println(dp[size]);

    }
}
