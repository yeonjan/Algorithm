import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n, k, p, x;
    static int[][] num = {
            {1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 0, 0, 0, 0},
            {1, 1, 0, 1, 1, 0, 1},
            {1, 1, 1, 1, 0, 0, 1},
            {0, 1, 1, 0, 0, 1, 1},
            {1, 0, 1, 1, 0, 1, 1},
            {1, 0, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0, 1, 1}
    };
    static int[][] delta = new int[10][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        int ans = 0;
        for (int f = 1; f <= n; f++) {
            if (f == x) continue;
            int diff = getDiff(x, f);
            if (diff <= p) {
                ans++;
            }
        }
        System.out.println(ans);


    }

    public static int getDiff(int x, int floor) {
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 7; j++) {
                if (num[x % 10][j] != num[floor % 10][j]) cnt++;
                if (cnt > p) {
                    return Integer.MAX_VALUE;
                }
            }
            x /= 10;
            floor /= 10;
        }

        return cnt;
    }


}