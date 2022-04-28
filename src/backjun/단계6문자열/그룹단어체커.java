package backjun.단계6문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 그룹단어체커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < N; ++i) {
            String word = br.readLine();
            if (is_group(word)) cnt++;
        }
        System.out.println(cnt);
    }

    public static boolean is_group(String word) {
        char last = '0';
        for (int i = 0; i < word.length(); ++i) {
            char now = word.charAt(i);
            if (now != last) {
                if (word.lastIndexOf(last) != i - 1)
                    return false;
            }
            last = now;
        }
        return true;
    }
}
