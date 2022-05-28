package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 부분수열의합 {
    static Integer[] arr;
    static int k;
    static int size;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= t; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            count = 0;

            String[] input = br.readLine().split(" ");
            arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }
            Arrays.sort(arr, Collections.reverseOrder());

            for (int i = 0; i < n; i++) {
                size = i + 1;
                isK(0, 0, 0);
            }
            System.out.println("#" + test_case + " " + count);
        }
    }

    public static void isK(int depth, int at, int value) {

        if (depth == size) {
            if (value == k)
                count++;
            return;
        }
        for (int i = at; i < arr.length; i++) {
            if (arr[i] > k)
                continue;
            value += arr[i];
            isK(depth + 1, i + 1, value);
            value -= arr[i];
        }
    }

}
