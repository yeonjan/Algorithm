package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 문자열폭발 {
    static Stack<Character> stack = new Stack<>();
    static int bombSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        String bomb = br.readLine();
        bombSize = bomb.length();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
            if (stack.size() >= bombSize && stack.peek().equals(bomb.charAt(bombSize - 1))) {
                if (isBomb(bomb)) {
                    for (int j = 0; j < bombSize; j++) {
                        stack.pop();
                    }

                }
            }
        }

        if (stack.isEmpty()) sb.append("FRULA");
        else {
            for (Character s : stack) {
                sb.append(s);
            }
        }
        System.out.println(sb);

    }

    public static boolean isBomb(String bomb) {
       for (int i = 0; i < bombSize; i++) {
            if (stack.get(stack.size() - bombSize + i)!=(bomb.charAt(i))) return false;
        }
        return true;
    }
}
