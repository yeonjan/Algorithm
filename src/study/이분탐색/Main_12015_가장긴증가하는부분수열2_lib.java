package study.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_12015_가장긴증가하는부분수열2_lib {
    static int lastIndex, target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] lis = new int[n];
        int[] a = new int[n];
        Arrays.fill(lis, Integer.MAX_VALUE);

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        lis[0] = a[0];
        lastIndex = 0;

        for (int i = 1; i < n; i++) {
            target = a[i];

            //lis의 마지막 값보다 큰 경우 그냥 추가
            if (target > lis[lastIndex]) lis[++lastIndex] = target;
            else {
                int re = Arrays.binarySearch(lis, target);
                if (re < 0) lis[-re - 1] = target;
            }
        }

        System.out.println(lastIndex + 1);
    }
}

