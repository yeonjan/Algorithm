package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1461_도서관 {
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.valueOf(st.nextToken()));

        }
        Collections.sort(list);

        int low = 0;
        int high = n - 1;
        int ans = 0;

        if (Math.abs(list.get(0)) > Math.abs(list.get(n - 1))) {
            ans += Math.abs(list.get(0));
            low += m;
        } else {
            ans += Math.abs(list.get(n - 1));
            high -= m;
        }

        while (low < n && list.get(low) < 0) {
            int lowNum = Math.abs(list.get(low));
            ans += lowNum * 2;
            low += m;
        }
        while (high >= 0 && list.get(high) > 0) {
            int highNum = Math.abs(list.get(high));
            ans += highNum * 2;
            high -= m;
        }
        System.out.println(ans);


    }
}
