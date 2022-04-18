package backjun.단계3for;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 별찍기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; ++i) {
            sb.append(" ".repeat(N-i)).append("*".repeat(i)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
