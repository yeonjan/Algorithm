package ssafy.과제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {
    static int M, N, size;
    static ArrayList<int[]> chicken, home;
    static boolean[] visit;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        chicken = new ArrayList<>();
        home = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if (cur == 1) home.add(new int[]{i, j});
                else if (cur == 2) chicken.add(new int[]{i, j});
            }
        }

        size = chicken.size();
        visit = new boolean[size];
        dfs(0, 0, visit);

        System.out.println(answer);


    }

    public static void dfs(int start, int cnt, boolean[] visit) {
        if (cnt == M) {
            answer = Math.min(countChickenDist(visit), answer);
            return;
        }

        for (int i = start; i < size; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i + 1, cnt + 1, visit);
                visit[i] = false;
            }
        }
    }

    public static int countChickenDist(boolean[] visit) {
        int sum = 0;
        for (int[] h : home) {
            int dist = Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                if (visit[i]) {
                    int[] curChicken = chicken.get(i);
                    dist = Math.min(Math.abs(curChicken[0] - h[0]) + Math.abs(curChicken[1] - h[1]), dist);
                }
            }
            sum += dist;
        }
        return sum;
    }
}
