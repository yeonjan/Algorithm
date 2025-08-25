import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] str = br.readLine().split("");
        String[] bomb = br.readLine().split("");
        int size = bomb.length;

        Stack<String> stack = new Stack<>();
        for (String s : str) {
            stack.push(s);
            if (stack.peek().equals(bomb[size - 1])) {
                boolean isBomb = true;
                int cnt = 0;
                if (stack.size() < size) continue;
                for (int i = size - 1; i >= 0; i--) {
                    if (!stack.peek().equals(bomb[i])) {
                        isBomb = false;
                        break;
                    }
                    cnt++;
                    stack.pop();
                }
                if (!isBomb) {
                    for (int i = cnt; i > 0; i--) {
                        stack.push(bomb[size - i]);
                    }
                }
            }
        }
        if (stack.isEmpty()){
            sb.append("FRULA");
        }else {
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            sb.reverse();
        }

        System.out.println(sb);

    }


}
