package study.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1920_수찾기 {
    static int n;
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        a = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            if (binarySearch(Integer.parseInt(st.nextToken()))) sb.append("1");
            else sb.append("0");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static boolean binarySearch(int num) {
        int start = 0, end = n - 1, mid;
        while (start <= end) {
            mid = (start + end) / 2;

            if (num == a[mid]) {
                return true;
            } else if (num < a[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

}
