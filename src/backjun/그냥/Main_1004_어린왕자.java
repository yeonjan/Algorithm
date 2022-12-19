package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1004_어린왕자 {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int[] start = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            int[] end = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            int n = Integer.parseInt(br.readLine());
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                boolean s = hasContain(start[0], start[1], cx, cy, r);
                boolean e = hasContain(end[0], end[1], cx, cy, r);

                if (s && e) continue;

                if (s) cnt++;
                if (e) cnt++;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);


    }

    public static boolean hasContain(int x, int y, int cx, int cy, int r) {
        return r > Math.sqrt(Math.pow(cx - x, 2) + Math.pow(cy - y, 2));
    }
}
