package backjun.알고리즘기초.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 날짜계산 {
    static int e, m, s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        e = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        int answer = 0;
        while (!isDay(++answer)) {
        }

        System.out.println(answer);
    }

    public static boolean isDay(int i) {
        int E = (i - 1) % 15 + 1;
        int M = (i - 1) % 28 + 1;
        int S = (i - 1) % 19 + 1;

        if (E != e ) return false;

        if (M != m) return false;

        if (S != s) return false;

        return true;
    }
}
