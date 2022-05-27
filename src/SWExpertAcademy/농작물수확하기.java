package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 농작물수확하기 {
    static int cnt;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            n = Integer.parseInt(br.readLine());
            cnt = 0;

            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split("");
                int size = n - 1;
                if (i > n / 2) {
                    calculate(input, size - i);
                } else {

                    calculate(input, i);
                }
            }
            System.out.println("#" + test_case + " " + cnt);
        }

    }

    public static void calculate(String[] arr, int size) {
        int center = n / 2;
        for (int i = center - size; i <= center + size; i++) {
            cnt += Integer.parseInt(arr[i]);
        }

    }
}
