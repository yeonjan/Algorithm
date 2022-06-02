package backjun.단계별로풀어보기.단계6문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자열반복 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; ++i) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            char[] S = st.nextToken().toCharArray();

            for (int j = 0; j < S.length; ++j) {
                sb.append(String.valueOf(S[j]).repeat(R));
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
