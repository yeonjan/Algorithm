package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 문자열폭발2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        String input = br.readLine();
        String bomb = br.readLine();


        for (int i = 0; i < input.length(); i++) {
            //1. 문자열을 순서대로 스택에 push
            stack.push(input.charAt(i));

            //2. 폭발 문자열을 포함한다면 스택에서 pop
            if (isBomb(stack, bomb)) {
                for (int j = 0; j < bomb.length(); j++) {
                    stack.pop();
                }
            }
        }

        //출력
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

        //스택의 크기가 폭발 문자열보다 작은경우
        if (stack.size() < bomb.length()) return false;

        // 마지막으로 넣은 문자 != 폭발 문자열의 마지막 문자
        if (!stack.peek().equals(bomb.charAt(bomb.length() - 1))) return false;

        //스택을 순회하며 폭발문자열과 같은지 비교
        for (int i = 0; i < size; i++) {
            if (stack.get(stack.size() - size + i) != (bomb.charAt(i))) return false;
        }

        return true;
    }
}
