import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        int[][] words = new int[n][26];

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < input.length; j++) {
                words[i][input[j] - 'A']++;
            }
        }

        for (int i = 1; i < n; i++) {
            int required = 0;
            int spare = 0;
            for (int j = 0; j < 26; j++) {
                if (words[0][j] < words[i][j]) {
                    spare += words[i][j] - words[0][j];
                } else if (words[0][j] > words[i][j]) {
                    required += words[0][j] - words[i][j];
                }
            }

            if (spare == 0 && required == 0) ans++;
            else if ((spare - 1 == 0 && required == 0) || (spare == 0 && required - 1 == 0) || (spare - 1 == 0 && required - 1 == 0)) ans++;
        }

        System.out.println(ans);


    }


}
