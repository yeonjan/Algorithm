package study.스택_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수 {
    static int N;
    static int[] ans;
    static int[] sequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        N = Integer.parseInt(br.readLine());
        ans = new int[N];
        sequence = new int[N];
        Arrays.fill(ans,-1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && sequence[stack.peek()] < sequence[i]) {
                ans[stack.pop()] = sequence[i];
            }
            stack.push(i);
        }

        for(int i=0;i<N;i++){
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }
}