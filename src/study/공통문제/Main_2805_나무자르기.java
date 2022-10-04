package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2805_나무자르기 {
    static int n, h;
    static long m;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        tree = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        int low = 0, high = 1000000000;

        while (low <= high) {
            h = (low + high) / 2;
            if (h == low || h == high) break;
            long sum = cut(h);

            if (sum > m) low = h;
            else if (sum < m) high = h;
            else break;

        }
        System.out.println(h);
    }

    public static long cut(int h) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.max(0, tree[i] - h);
        }
        return sum;

    }
}
