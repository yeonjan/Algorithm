package backjun.알고리즘기초.순열조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10974_모든순열 {
    static int N;
    static int[] selected;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visit = new boolean[N + 1];
        selected = new int[N];
        permutation(0, visit);
        System.out.println(sb.toString());


    }

    public static void permutation(int cnt, boolean[] visit) {
        if (cnt == N) {
            for (int i : selected) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                selected[cnt] = i;
                permutation(cnt + 1, visit);
                visit[i] = false;
            }
        }


    }
}
