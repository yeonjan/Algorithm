package backjun.단계별로풀어보기.단계6문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 알파벳찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        String S = br.readLine();
        for (char i = 'a'; i <= 'z'; ++i) {
            sb.append(S.indexOf(i)).append(" ");
        }

        /*
        int[] index = new int[26];
        Arrays.fill(index, -1);


        char[] S = br.readLine().toCharArray();
        for (int i = 0; i < S.length; ++i) {
            int alphabet = S[i] - 'a';

            if (index[alphabet] == -1) {
                index[alphabet] = i;
            }
        }

        for(int idx:index){
            sb.append(idx).append(" ");
        }*/

        System.out.println(sb);

    }
}
