package backjun.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_10816_숫자카드2 {
    static int n, m;
    static ArrayList<Integer> card = new ArrayList<>();
    static ArrayList<Integer> question = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            card.add(Integer.valueOf(st.nextToken()));
        }
        Collections.sort(card);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            question.add(Integer.valueOf(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        for (int q : question) {
            sb.append(upperBound(q) - lowerBound(q)).append(" ");


        }
        System.out.println(sb.toString());


    }

    public static int lowerBound(int target) {
        int low = 0;
        int high = n ;

        while (low < high) {
            int mid = (low + high) / 2;
            int midVal = card.get(mid);

            if (midVal >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;

    }

    public static int upperBound(int target) {
        int low = 0;
        int high = n;

        while (low < high) {
            int mid = (low + high) / 2;
            int midVal = card.get(mid);

            if (midVal <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high;
    }
}
