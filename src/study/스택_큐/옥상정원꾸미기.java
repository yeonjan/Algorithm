package study.스택_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 옥상정원꾸미기 {
    static long[] building;
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        building = new long[n];
        ans = 0;

        for (int i = 0; i < n; i++) {
            building[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && building[stack.peek()] <= building[i]) {
                ans+= i - stack.pop() - 1;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            ans+= building.length-stack.pop()-1;
        }
        System.out.println(ans);
    }
}
