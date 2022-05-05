package backjun.단계8기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 직사각형에서탈출 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int route1 = 0;
        int route2 = 0;

        if (x >= w - x) {
            route1 = w - x;
        } else route1 = x;

        if (y >= h - y) {
            route2 = h - y;
        } else route2 = y;

        System.out.println(Math.min(route1, route2));
    }
}
