package backjun.단계별로풀어보기.단계8기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 택시기하학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int r = Integer.parseInt(br.readLine());

        sb.append(Math.PI * r * r).append("\n");
        sb.append((double) 2 * r * r).append("\n");

        System.out.println(sb);

    }
}
