import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n;
    static Map<Character, String> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        Re:
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            String[] words = input.split(" ");
            //case1
            int idx = 0;
            for (int j = 0; j < words.length; j++) {
                String word = words[j].toLowerCase();
                if (!map.containsKey(word.charAt(0))) {
                    map.put(word.charAt(0), input);
                    saveSb(idx, input);
                    continue Re;
                }
                idx += word.length() + 1;
            }

            //case2
            String lowerCase = input.toLowerCase();
            for (int j = 0; j < input.length(); j++) {
                if (lowerCase.charAt(j) == ' ') {
                    continue;
                }
                if (!map.containsKey(lowerCase.charAt(j))) {
                    map.put(lowerCase.charAt(j), input);
                    saveSb(j, input);
                    continue Re;
                }
            }

            //case3
            saveSb(-1, input);


        }
        System.out.println(sb.toString());


    }

    public static void saveSb(int idx, String option) {
        if (idx < 0) {
            sb.append(option).append("\n");
            return;
        }

        String first = option.substring(0, idx);
        String last = option.substring(idx + 1);
        sb.append(first).append("[").append(option.charAt(idx)).append("]").append(last).append("\n");

    }

}