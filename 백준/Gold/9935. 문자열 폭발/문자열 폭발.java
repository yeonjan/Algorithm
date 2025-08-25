import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        String input = br.readLine();
        String bomb = br.readLine();


        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
            if (isBomb(stack, bomb)) {
                for (int j = 0; j < bomb.length(); j++) {
                    stack.pop();
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

    public static boolean isBomb(Stack<Character> stack, String bomb) {
        int size = bomb.length();

        if (stack.size() < bomb.length()) return false;

        if (!stack.peek().equals(bomb.charAt(bomb.length() - 1))) return false;

        for (int i = 0; i < size; i++) {
            if (stack.get(stack.size() - size + i) != (bomb.charAt(i))) return false;
        }

        return true;
    }
}