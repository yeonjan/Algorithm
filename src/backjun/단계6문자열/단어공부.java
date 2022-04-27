package backjun.단계6문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단어공부 {
    static int ALPHABET = 26;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] word = br.readLine().toUpperCase().toCharArray();
        int[] count = new int[ALPHABET];
        int max = -1;
        int idx = -1;
        boolean is_duplicate = false;

        //알파벳 개수 세기
        for (char a : word) {
            count[a - 'A']++;
        }

        //가장 많이 나온 알파벳과 위치 계산
        for (int i = 0; i < ALPHABET; i++) {
            if (max < count[i]) {
                is_duplicate=false;
                max = count[i];
                idx = i;
            } else if (max == count[i]) {
                is_duplicate=true;
            }
        }

        if (!is_duplicate) {
            System.out.println((char) (idx + 'A'));
        } else System.out.println("?");
    }
}
