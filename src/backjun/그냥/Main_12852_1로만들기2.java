package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main_12852_1로만들기2 {
    static int n;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());


        dp = new int[n + 1][2]; //{최소 카운트, 이전값}
        for (int i = 0; i <= n; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }


        trace(n, 0);

        sb.append(dp[1][0]).append("\n");
        int idx = 1;
        stack.add(1);
        while (idx != n) {
            stack.add(dp[idx][1]);
            idx = dp[idx][1];
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb.toString());

    }


    public static void trace(int from, int cnt) {
        if (from < 1) {
            return;
        }

        int next;
        dp[from][0] = cnt;

        if (from % 3 == 0) {
            next = from / 3;
            setDp(from, cnt, next);
        }

        if (from % 2 == 0) {
            next = from / 2;
            setDp(from, cnt, next);

        }

        next = from - 1;
        setDp(from, cnt, next);


    }

    private static void setDp(int from, int cnt, int next) {

        if (dp[next][0] > cnt + 1) {
            dp[next][1] = from;
            trace(next, cnt + 1);
        }
    }


}
