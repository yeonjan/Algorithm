import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_20437_문자열게임2{
    static int T, k;
    static char[] input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            input = br.readLine().toCharArray();
            k = Integer.parseInt(br.readLine());

            if (k == 1) {
                sb.append(1+" "+1).append("\n");
                continue;
            }

            int[] cnt = new int[26];
            for (char a : input) {
                cnt[a - 'a']++;
            }

            int min = Integer.MAX_VALUE, max = -1;

            for (int l = 0; l < input.length; l++) {
                if (cnt[input[l] - 'a'] < k) continue;

                int countKey = 1;
                for (int r = l + 1; r < input.length; r++) {
                    if (input[r] == input[l]) countKey++;

                    if (countKey == k) {
                        int length = r - l + 1;
                        max = Math.max(max, length);
                        min = Math.min(min, length);

                        break;
                    }
                }
            }

            if (min == Integer.MAX_VALUE || max == -1) sb.append(-1).append("\n");
            else sb.append(min + " " + max).append("\n");
        }


        System.out.println(sb.toString());
    }


}

