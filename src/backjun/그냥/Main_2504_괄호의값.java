package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_2504_괄호의값 {
	static int total = 0;
	static int n = 1;
	static Stack<Character> stack = new Stack<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		boolean flag = false;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);

			if (c == '(' || c == '[') {
				if (flag) {
					countNum(n);
					flag = false;
				}
				stack.push(c);
			} else if ((c == ')' && !stack.isEmpty() && stack.peek() == '(')) {
				n *= 2;
				flag = true;
				stack.pop();
			} else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
				n *= 3;
				flag = true;
				stack.pop();
			} else {
				flag = false;
				total = 0;
				break;
			}
		}

		if (flag)
			countNum(n);
		System.out.println(stack.isEmpty() ? total : 0);

	}

	public static void countNum(int num) {
		for (Object o : stack.toArray()) {
			if (o.equals('('))
				num *= 2;
			else if (o.equals('['))
				num *= 3;
		}
		total = num != 1 ? total + num : total;
		n = 1;
	}
}
