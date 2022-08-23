package ssafy.수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1759_암호만들기_정연진 {
    static int L, C;
    static char[] target;
    static char[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        target = new char[C];
        selected = new char[L];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            target[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(target);

        comb(0, 0, 0);
        System.out.println(sb.toString());

    }

    public static void comb(int cnt, int start, int vow) {
        if (cnt == L) {
            if (vow >= 1 && L - vow >= 2) {
                for (char s : selected) sb.append(s);
                sb.append("\n");
            }
            return;
        }

        for (int i = start; i < C; i++) {
            selected[cnt] = target[i];
            if (selected[cnt] == 'a' || selected[cnt] == 'e' || selected[cnt] == 'i' || selected[cnt] == 'o' || selected[cnt] == 'u') {
                comb(cnt + 1, i + 1, vow + 1);
            } else {
                comb(cnt + 1, i + 1, vow);
            }
        }
    }

}
