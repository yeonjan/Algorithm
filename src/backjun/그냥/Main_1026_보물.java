package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1026_보물 {
    static int n;

    static ArrayList<Integer> listA = new ArrayList<>();
    static ArrayList<Integer> listB = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            listA.add(Integer.valueOf(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            listB.add(Integer.valueOf(st.nextToken()));
        }

        listA.sort(Comparator.reverseOrder());
        listB.sort(Comparator.naturalOrder());

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += listA.get(i) * listB.get(i);
        }

        System.out.println(sum);


    }
}
