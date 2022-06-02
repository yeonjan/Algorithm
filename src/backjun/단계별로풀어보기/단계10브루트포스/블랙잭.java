package backjun.단계별로풀어보기.단계10브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 블랙잭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Integer[] cards = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards, Collections.reverseOrder());

        int max = 0;
        
        for (int i = 0; i < n - 2; ++i) {
            for (int k = i + 1; k < n - 1; ++k) {
                for (int h = k + 1; h < n; ++h) {
                    int value = cards[i] + cards[k] + cards[h];
                    if (value <= m) {
                        max = Math.max(max,value);
                    }
                }
            }
        }

        System.out.println(max);
    }
}
