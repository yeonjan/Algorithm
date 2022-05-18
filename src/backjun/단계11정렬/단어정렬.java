package backjun.단계11정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for (int i = 0; i < n; ++i) {
            words[i] = br.readLine();
        }

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (a.length() > b.length()) {
                    return 1;
                } else if (a.length() < b.length()) {
                    return -1;
                } else {
                    return a.compareTo(b);
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        String temp = "";
        for (String w : words) {
            if (temp.equals(w))
                continue;
            sb.append(w).append("\n");
            temp = w;
        }
        System.out.println(sb);

    }

}
