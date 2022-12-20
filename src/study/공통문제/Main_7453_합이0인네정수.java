package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_7453_합이0인네정수 {
    static long[] A, B, C, D;
    static long[] list1, list2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        A = new long[n];
        B = new long[n];
        C = new long[n];
        D = new long[n];
        list1 = new long[n * n];
        list2 = new long[n * n];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Long.parseLong(st.nextToken());
            B[i] = Long.parseLong(st.nextToken());
            C[i] = Long.parseLong(st.nextToken());
            D[i] = Long.parseLong(st.nextToken());
        }

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                list1[idx] = A[i] + B[j];
                list2[idx] = C[i] + D[j];
                idx++;
            }
        }

        Arrays.sort(list1);
        Arrays.sort(list2);

        long ans = 0;
        for (long l : list1) {
            int lowerIdx = lowerBound(list2, -l);
            int upperIdx = upperBound(list2, -l);

            if (list2[upperIdx] == -l) upperIdx++;

            ans += upperIdx - lowerIdx;
        }
        System.out.println(ans);


    }

    public static int upperBound(long[] list, long target) {
        int begin = 0;
        int end = list.length - 1;

        while (begin < end) {
            int mid = (begin + end) / 2;

            if (list[mid] <= target) begin = mid + 1;
            else end = mid;
        }
        return end;
    }

    public static int lowerBound(long[] list, long target) {
        int begin = 0;
        int end = list.length - 1;

        while (begin < end) {
            int mid = (begin + end) / 2;

            if (list[mid] >= target) end = mid;
            else begin = mid + 1;
        }
        return end;
    }
}
