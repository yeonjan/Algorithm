import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N, K;
    static int[] machine;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        machine = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            machine[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(500, new boolean[N], 0);

        System.out.println(ans);

    }

    public static void backtracking(int weight, boolean[] used, int cnt) {
        if (weight < 500) {
            return;
        }
        if (cnt == N) {
            ans++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                used[i] = true;
                backtracking(weight + machine[i] - K, used, cnt + 1);
                used[i] = false;
            }
        }

    }


}

