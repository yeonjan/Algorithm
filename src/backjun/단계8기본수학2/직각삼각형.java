package backjun.단계8기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 직각삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[] leg = new int[3];

        while (true) {
            st = new StringTokenizer(br.readLine());
            leg[0] = Integer.parseInt(st.nextToken());
            leg[1] = Integer.parseInt(st.nextToken());
            leg[2] = Integer.parseInt(st.nextToken());

            Arrays.sort(leg);

            if (leg[0] == 0 && leg[1] == 0 && leg[2] == 0) break;

            if ((leg[0]  * leg[0] ) + (leg[1]  * leg[1] ) == (leg[2]  * leg[2] )) {
                sb.append("right").append("\n");
            } else sb.append("wrong").append("\n");

        }
        System.out.println(sb);
    }
}
