package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6603_로또 {
    static int k;
    static int[] s;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            s = new int[k];
            selected = new int[6];
            for (int i = 0; i < k; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }
            comb(0, 0);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void comb(int cnt, int start) {
        if (cnt == 6) {
            print(selected);
            return;
        }

        for (int i = start; i < k; i++) {
            selected[cnt] = s[i];
            comb(cnt + 1, i + 1);
        }


    }

    public static void print(int[] selected) {
        for (int s : selected) sb.append(s + " ");
        sb.append("\n");
    }
}
