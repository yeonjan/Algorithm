import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int ans = 0;
        int player = getPlayerNum(st.nextToken());
        int countUser = 0;
        for (int i = 0; i < N; i++) {
            String user = br.readLine();
            if (!map.containsKey(user)) {
                map.put(user, 0);
                countUser++;
            }

            if (countUser == player) {
                ans++;
                countUser = 0;
            }
        }
        System.out.println(ans);


    }

    public static int getPlayerNum(String type) {
        if (type.equals("Y")) {
            return 1;
        } else if (type.equals("F")) {
            return 2;
        } else {
            return 3;
        }
    }


}