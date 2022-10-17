package ssafy.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo2_2_대전_7_정연진 {
    static int T, V, P, L, ans;
    static int[] city;
    static int[] dist;
    static int[] isSelect;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        //테스트 케이스만큼 반복
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            //V,P,L입력
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            //마을 정보 입력받아 배열에 저장
            city = new int[V];
            dist = new int[V];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < V; i++) {
                city[i] = Integer.parseInt(st.nextToken());
                dist[i] = Integer.MAX_VALUE;
            }

            //
            isSelect = new int[P];
            ans = Integer.MAX_VALUE;
            comb(0, 0, dist);
            sb.append("#" + t + " " + ans + "\n");
        }
        System.out.println(sb);

    }

    public static void comb(int cnt, int start, int[] dist) {
        if (cnt == P) {
            //System.out.println(Arrays.toString(isSelect));
            //System.out.println(Arrays.toString(dist));
            int sum = 0;
            for (int d : dist) {
                sum += d;
            }
            ans = Math.min(ans, sum);
            //System.out.println(ans);
            return;
        }
        for (int i = start; i < V; i++) {
            isSelect[cnt] = city[i];
            int[] dist2 = calcDist(city[i], dist);
            comb(cnt + 1, i + 1, dist2);
        }
    }


    public static int[] calcDist(int pol, int[] dist) {
        int[] dist2 = dist.clone();
        for (int i = 0; i < V; i++) {
            int abs = Math.abs(city[i] - pol);
            int min = Math.min(abs, L - abs);
            dist2[i] = Math.min(min, dist2[i]);
        }
        return dist2;
    }

}
