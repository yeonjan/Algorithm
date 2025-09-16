package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main_2661_좋은수열 {
    static int n;
    static int h;
    static int min = Integer.MAX_VALUE;
    static int ans;
    static List<Integer> upper = new ArrayList<>();
    static List<Integer> lower = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                lower.add(Integer.valueOf(br.readLine()));
            } else {
                upper.add(Integer.valueOf(br.readLine()));
            }
        }
        Collections.sort(lower);
        Collections.sort(upper);

        for (int i = 1; i <= h; i++) {
            int size = 0;
            size += getCount(lower, i);
            size += getCount(upper, h - i + 1);

            if (size < min) {
                min = size;
                ans = 1;
            } else if (size == min) {
                ans++;
            }
        }


        System.out.println(min + " "+ans);


    }

    public static int getCount(List<Integer> arr, int key) {
        int i = binarySearch(arr, key);
        return n / 2 - i;

    }

    public static int binarySearch(List<Integer> arr, int key) {
        int low = 0;
        int high = n / 2;
        while (low < high) {
            int mid = (low + high) / 2;
            int midVal = arr.get(mid);
            if (midVal >= key) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}

//i번 탐색
//석순 -> i 이상인거 / 종유석 -> (h-i)+1 이상이어야 닿음
