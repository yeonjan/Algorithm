package backjun.알고리즘기초.자료구조1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int test = 0; test < t; test++) {
            Stack<String> stack = new Stack<>();
            String[] input = br.readLine().split("");

            for (String s : input) {
                if (!stack.isEmpty()) {
                    if (s.equals(")") && stack.peek().equals("(")) {
                        stack.pop();
                        continue;
                    }
                }
                stack.push(s);
            }
            sb.append(stack.isEmpty() ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }
}
