package backjun.단계별로풀어보기.단계15백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M1 {
    static int n;
    static int m;
    static int[] arr;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int size = n;
        for (int i = 1; i < n; i++) {
            size *= (size - i);
        }
        arr = new int[m];
        visit = new boolean[n];
        dfs(0);

        System.out.println(sb.toString());

    }

    public static void dfs(int depth) {
        if (depth == m) {
            for (int a : arr) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1);

                visit[i] = false;
            }
        }
    }
}
