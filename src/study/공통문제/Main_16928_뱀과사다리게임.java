package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_16928_뱀과사다리게임 {
    static int n, m;
    static int[] visited = new int[101];
    static int[] snl = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        Arrays.fill(snl, -1);
        Arrays.fill(visited, Integer.MAX_VALUE);
        for (int i = 0; i < n + m; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            snl[x] = y;
        }

        dfs(1, 0);
        System.out.println(visited[100]);

    }

    public static void dfs(int idx, int cnt) {
        visited[idx] = cnt;

        if (cnt > visited[100]) return;
        if (idx == 100) return;

        for (int dice = 1; dice <= 6; dice++) {
            int next = idx + dice;
            if (next > 100) break;

            //사다리 혹은 뱀이 있다면
            if (snl[next] > 0) next = snl[next];

            if (visited[next] > cnt + 1) {
                dfs(next, cnt + 1);
            }
        }
    }
}
