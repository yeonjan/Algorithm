package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9655_돌게임 {
    static String[] player = new String[]{ "CY","SK"};
    static int n;
    static int ans;
    static boolean end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
//        dfs(0, 0);
        System.out.println(player[n%2]);
    }

    public static void dfs(int cnt, int p) {
        if (end) return;
        if (cnt > n) {
            return;
        }
        if (cnt == n) {
            ans = -(p - 1);
            end=true;
            return;
        }


        for (int i = 0; i < 2; i++) {
            dfs(cnt + 1, -(p - 1));
            dfs(cnt + 3, -(p - 1));
        }
    }
}
// 1-> sk
//2->cy
//3->sk
//4->cy
