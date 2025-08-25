import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        String bomb = br.readLine();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            bomb(bomb, stack);
        }
        if (stack.isEmpty()) {
            sb.append("FRULA");
        } else {
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            sb.reverse();
        }

        System.out.println(sb);

    }

    public static void bomb(String bomb, Stack<Character> stack) {
        int size = bomb.length();
        if (stack.size() < size) return;
        if (!stack.peek().equals(bomb.charAt(size - 1))) return;

        boolean isBomb = true;
        int cnt = 0;
        for (int i = 0; i < size; i++) {
            if (!stack.peek().equals(bomb.charAt(size - i - 1))) {
                isBomb = false;
                break;
            }
            stack.pop();
            cnt++;

        }
        if (!isBomb) {
            for (int i = cnt; i > 0; i--) {
                stack.push(bomb.charAt(size - i));
            }
        }
    }


}

