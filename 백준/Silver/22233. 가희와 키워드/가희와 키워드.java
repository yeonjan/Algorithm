import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n, m;
    static Map<String, Boolean> map = new HashMap<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            map.putIfAbsent(input, true);
            cnt++;
        }
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(",");
            for (String str : input) {
                if (map.containsKey(str)) {
                    map.remove(str);
                    cnt--;
                }
            }
            System.out.println(cnt);
        }

    }


}