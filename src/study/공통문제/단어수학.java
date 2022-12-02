package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 단어수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        int[] alphabet = new int[26];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < temp.length(); j++) {
                alphabet[temp.charAt(j) - 'A'] += Math.pow(10, temp.length() - j - 1);
            }
        }

        Arrays.sort(alphabet);

        for (int i = 25, num = 9; i > 0; i--, num--) {
            answer += alphabet[i] * num;
        }
        System.out.println(answer);
    }
}