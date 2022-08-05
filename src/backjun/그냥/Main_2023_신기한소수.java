package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2023_신기한소수 {
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String str = "";

        DFS(str,0);
        System.out.println(sb.toString());


    }

    public static void DFS(String strNum, int depth) {
        if (depth == N) {
            sb.append(strNum).append("\n");
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (isPrime(Integer.parseInt(strNum + i))) {
                DFS(strNum + i, depth + 1);
            }
        }
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
