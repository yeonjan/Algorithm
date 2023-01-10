package backjun.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10773_제로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int sum = 0;
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0 && !stack.isEmpty()) {
                stack.pop();
                continue;
            }

            stack.push(input);
        }
        while (!stack.isEmpty()) {
            sum+=stack.pop();
        }

        System.out.println(sum);

    }
}
