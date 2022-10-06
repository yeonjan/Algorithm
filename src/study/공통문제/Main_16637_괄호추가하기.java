package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16637_괄호추가하기 {
    static int n, ans = Integer.MIN_VALUE;
    static char[] opt;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        num = new int[n / 2 + 1]; //숫자
        opt = new char[n / 2]; //연산자

        String input = br.readLine();
        int idx = 0;
        //입력받은 수식을 num과 opt로 분리
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) num[idx] = input.charAt(i) - '0';
            else opt[idx++] = input.charAt(i);
        }

        dfs(0,num[0]);
        System.out.println(ans);
    }

    public static void dfs(int idx, int total) {
        if (idx == n / 2) {
            ans = Math.max(ans, total);
            return;
        }

        //괄호를 추가하지 않는 경우
        dfs(idx + 1, calculate(total, num[idx + 1], opt[idx]));

        //바로 뒤 연산자를 먼저 계산한 경우
        if (idx + 1 < opt.length) {
            int next = calculate(num[idx + 1], num[idx + 2], opt[idx + 1]);
            dfs(idx + 2, calculate(total, next, opt[idx]));
        }

    }

    //연산을 위한 함수
    public static int calculate(int a, int b, char opt) {
        switch (opt) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
        }
        return -1;
    }
}
