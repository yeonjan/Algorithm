package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9663_NQueen {
    static int n, ans;
    static int[] selected;
    static int[] delta = {0, -1, 1};
    static boolean[] isSpace;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        isSpace = new boolean[n];
        selected = new int[n];

        dfs(0);
        System.out.println(ans);

    }

    public static void dfs(int depth) {
        if (depth == n) {
            ans++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isAttackSpace(depth, i)) {
                selected[depth] = i;
                dfs(depth + 1);
            }
        }
    }

    public static boolean isAttackSpace(int depth, int nowC) {
        for (int i = 0; i < depth; i++) {
            int c = selected[i];
            for (int j = 0; j < 3; j++) {
                int d = c + (depth - i) * delta[j];
                if (nowC == d) return true;
            }
        }
        return false;
    }

}
