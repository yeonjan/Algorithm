import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 오른쪽으로 이동하며, 높이가 처음 등장-> 스택에 넣기/ 높이가 바뀜 -> 스택에서 뺴기 count++

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        int[] skyLine = new int[n + 1];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            skyLine[i] = Integer.parseInt(input[1]);
        }
        skyLine[n] = 0;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n + 1; i++) {
            if (stack.isEmpty()) {
                stack.push(skyLine[i]);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > skyLine[i]) {
                cnt++;
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek() == skyLine[i]) continue;
            stack.push(skyLine[i]);

        }

        System.out.println(cnt);

    }
}

