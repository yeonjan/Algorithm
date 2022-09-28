package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1253_좋다 {
    static int n, ans;
    static Integer[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new Integer[n + 1];
        a[n] = 1000000001;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            if (a[i].equals(a[i + 1])) cnt++;
            else {
                for (int num1 = 0; num1 < n; num1++) {
                    if (i == num1) continue;
                    if (binarySearch(a[i] - a[num1], Math.min(num1, i) - 1, Math.max(num1, i) + 1)) {
                        ans += cnt;
                        break;
                    }
                }
                cnt = 1;
            }
        }
        System.out.println(ans);
    }

    public static boolean binarySearch(int target, int under, int over) {
        int mid, lo = 0, hi = under;

        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (a[mid] == target) return true;
            else if (a[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }

        lo = over;
        hi = n - 1;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (a[mid] == target) return true;
            else if (a[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }
        return false;
    }
}

//-1 -1 0
// -3 -2 -1 1