import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String[] input = br.readLine().split("");
            if (isVPS(input)) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");

        }
        System.out.println(sb);


    }

    public static boolean isVPS(String[] arr) {
        int size = arr.length;
        Stack<String> stack = new Stack<>();
        for (String s : arr) {
            if (stack.isEmpty()) {
                stack.push(s);
                continue;
            }
            if (stack.peek().equals("(") && s.equals(")")) {
                stack.pop();
                continue;
            }
            stack.push(s);
        }

        return stack.isEmpty();
    }


}

