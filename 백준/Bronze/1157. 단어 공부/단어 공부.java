import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;
    static Map<String, Integer> map = new HashMap<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().toUpperCase();

        for (int i = 0; i < input.length(); i++) {
            String s = input.substring(i, i + 1);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int cnt = 0;
        String ans="?";
        for (String key : map.keySet()) {
            if (map.get(key) > cnt) {
                cnt = map.get(key);
                ans = key;
            } else if (map.get(key) == cnt) {
                ans = "?";

            }
        }


        System.out.println(ans);


    }

}