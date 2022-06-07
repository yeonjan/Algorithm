package backjun.알고리즘기초.자료구조1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 에디터 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        Stack<Character> stack = new Stack<>();
        Stack<Character> queue = new Stack<>();

        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        int M = Integer.parseInt(br.readLine());

        for (int m = 0; m < M; m++) {
            //StringTokenizer 로 받아서 char 로 바꾸는 것보다 String 으로 받기
            String input = br.readLine();

            switch (input.charAt(0)) {
                case 'L':
                    if (!stack.isEmpty()) {
                        queue.push(stack.pop());
                    }
                    break;
                case 'D':
                    if (!queue.isEmpty()) {
                        stack.push(queue.pop());
                    }
                    break;
                case 'B':
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                case 'P':
                    stack.push(input.charAt(2));
                    break;

            }
        }

        //출력
        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            queue.push(stack.pop());
        }

        while (!queue.isEmpty()){
            sb.append(queue.pop());
        }

        System.out.printf(sb.toString());

    }
}

