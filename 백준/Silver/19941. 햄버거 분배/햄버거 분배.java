import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cnt = 0;
        boolean[] visited = new boolean[n];
        String[] input = br.readLine().split("");
        for (int i = 0; i < n; i++) {
            if (input[i].equals("H")) continue;

            for (int j = i - k; j <= i + k; j++) {
                if (j < 0 || n <= j) continue;
                if (input[j].equals("H") && !visited[j]) {
                    visited[i] = true;
                    cnt++;
                    visited[j] = true;
                    break;
                }
            }
        }

        System.out.println(cnt);


    }


}
