package backjun.알고리즘기초.자료구조1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 스택수열 {
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //만들어야 할 수열
        Queue<Integer> sequence = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            sequence.offer(Integer.valueOf(br.readLine()));
        }

        //수열 만들기
        int num = 1;
        boolean isMake = true;
        while (!sequence.isEmpty()) {
            if (num > n + 1) {
                isMake = false;
                break;
            }
            if (stack.isEmpty()) {
                push(num);
                num++;
            } else if (sequence.peek().equals(stack.peek())) {
                pop();
                sequence.poll();
            } else {
                push(num);
                num++;
            }
        }

        System.out.printf(isMake ? sb.toString() : "NO");

    }

    public static void push(int n) {
        stack.push(n);
        sb.append("+" + "\n");
    }

    public static void pop() {
        stack.pop();
        sb.append("-" + "\n");
    }
}
