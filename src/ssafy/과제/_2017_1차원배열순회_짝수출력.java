package ssafy.과제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2017_1차원배열순회_짝수출력 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] arr = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19};

        System.out.println("-----원소 10개 출력-----");
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();

        System.out.println("-----원소 10개 중 짝수만 출력-----");
        for (int a : arr) {
            if (a % 2 == 0) System.out.print(a + " ");
        }
        System.out.println();

        System.out.println("-----바꿀 위치 입력 : ");
        int pos = Integer.parseInt(br.readLine());
        System.out.println("-----수 입력 : ");
        int value = Integer.parseInt(br.readLine());

        arr[pos] = value;

        System.out.println("-----원소 10개 출력-----");
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();

    }
}
