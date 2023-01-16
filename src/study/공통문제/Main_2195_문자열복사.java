package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2195_문자열복사 {
    public static String S;
    public static String P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        P = br.readLine();

        int ans = 0;
        int maxCount = 0;
        boolean find = false;
        for (int i = 0; i < P.length(); i++) {
            if (maxCount != 0) {
                ans++;
                i += maxCount - 1;
            }
            maxCount = 0;
            if (i >= P.length()) break;
            for (int j = 0; j < S.length(); j++) {
                int cnt = 0;
                int s = j;
                int p = i;
                if (S.charAt(s) != P.charAt(p)) continue;
                while (s < S.length() && p < P.length()) {
                    if (S.charAt(s) == P.charAt(p)) {
                        p++;
                        s++;
                        cnt++;
                        continue;
                    }
                    break;
                }
                maxCount = Math.max(maxCount, cnt);
            }
        }
        System.out.println(maxCount == 0 ? ans : ans + 1);


    }


}

