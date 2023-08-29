package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14562_태권왕 {
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int C = Integer.parseInt(br.readLine());

        for (int t = 0; t < C; t++) {
            ans = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            dfs(S, T, 0);
            sb.append(ans).append("\n");
        }
        System.out.println(sb.toString());

    }

    public static void dfs(int S, int T, int cnt) {
        if (S > T) return;
        if (S == T) {
            ans = Math.min(ans, cnt);
            return;
        }

        //킥1
        dfs(S * 2, T + 3, cnt + 1);

        //킥2
        dfs(S + 1, T, cnt + 1);

    }
}
