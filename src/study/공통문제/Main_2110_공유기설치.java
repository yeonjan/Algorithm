package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2110_공유기설치 {
    static int n, c, ans;
    static int[] home;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        home = new int[n];

        for (int i = 0; i < n; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(home);

        //거리 : 1 ~ 최대거리 사이에서 적절한 거리 이분 탐색으로 찾음
        int low = 1;
        int high = home[n - 1] - home[0];
        while (low <= high) {
            int dist = (low + high) / 2;

            if (canInstall(dist)) {
                ans = Math.max(ans, dist);
                low = dist + 1;
            } else high = dist - 1;

        }
        System.out.println(ans);


    }

    public static boolean canInstall(int dist) {
        //첫번째 위치에 공유기 항상 설치
        int cnt = 1;
        int lastRouter = home[0];

        for (int i = 1; i < n; i++) {
            if (home[i]-lastRouter  >= dist) {
                cnt++;
                lastRouter = home[i];
            }
            if (cnt == c) return true;
        }
        return false;

    }

}
