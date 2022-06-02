package backjun.단계별로풀어보기.단계11정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        for (int i = 0; i < n; ++i) {
            num[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < n - 1; ++i) {
            for (int k = 0; k < n - 1; ++k) {
                int temp;
                if (num[k] > num[k + 1]) {
                    temp = num[k];
                    num[k] = num[k + 1];
                    num[k + 1] = temp;
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            System.out.println(num[i]);
        }
    }
}
