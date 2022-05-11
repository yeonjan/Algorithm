package backjun.단계9재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 하노이탑이동순서 {
    static StringBuilder sb = new StringBuilder();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        hanoi(n, 1, 3, 2);
        System.out.println(count + "\n" + sb.toString());

    }

    public static void move(int n, int start, int end) {
        sb.append(start).append(" ").append(end).append("\n");
        count++;
    }

    public static void hanoi(int n, int start, int end, int temp) {
        if (n == 1) {
            move(n, start, end);
            return;
        }
        hanoi(n - 1, start, temp, end);
        move(n, start, end);
        hanoi(n - 1, temp, end, start);
    }
}
