import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void solve(int n, int[] buildings) {
        int[] leftSide = new int[n];
        int[] rightSide = new int[n];
        int[] nearIdx = new int[n];
        Arrays.fill(nearIdx, Integer.MAX_VALUE);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && buildings[stack.peek()] <= buildings[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                leftSide[i] = stack.size();
                nearIdx[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && buildings[stack.peek()] <= buildings[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                rightSide[i] = stack.size();
                if (Math.abs(stack.peek() - i) < Math.abs(nearIdx[i] - i)) {
                    nearIdx[i] = (stack.peek());
                }
            }


            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            if (leftSide[i] + rightSide[i] == 0) {
                System.out.println(0);
                continue;
            }
            System.out.println(leftSide[i] + rightSide[i] + " " + (nearIdx[i]+1));
        }


    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] buildings = new int[n];
        for (int i = 0; i < n; i++) {
            buildings[i] = Integer.parseInt(input[i]);
        }

        solve(n, buildings);


    }


}

