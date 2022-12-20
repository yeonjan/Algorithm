package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_2251_물통 {
    static int[] V = new int[3];
    static boolean[][][] visited;
    static boolean[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        V[0] = Integer.parseInt(st.nextToken());
        V[1] = Integer.parseInt(st.nextToken());
        V[2] = Integer.parseInt(st.nextToken());

        ans = new boolean[V[2] + 1];
        visited = new boolean[V[0] + 1][V[1] + 1][V[2] + 1];

        dfs(new int[]{0, 0, V[2]});


        for (int i = 0; i <= V[2]; i++) {
            if (ans[i]) sb.append(i + " ");
        }

        System.out.println(sb);

    }

    public static void dfs(int[] water) {

        if (water[0] == 0) {
            if (ans[water[2]]) return;
            ans[water[2]] = true;
        }

        for (int from = 0; from < 3; from++) {
            if (water[from] == 0) continue;

            for (int to = 0; to < 3; to++) {
                if (from == to) continue;

                int[] state = water.clone();

                int total = state[to] + state[from];

                if (total >= V[to]) state[to] = V[to];
                else state[to] = total;

                state[from] = total - state[to];
                if (!visited[state[0]][state[1]][state[2]]) {
                    visited[state[0]][state[1]][state[2]] = true;
                    dfs(state);
                }

            }
        }

    }
}
