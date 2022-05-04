package backjun.단계8기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 네번째점 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();
        StringTokenizer st;
        int[] arrX = new int[1001];
        int[] arrY = new int[1001];

        for (int i = 0; i < 3; ++i) {
            st = new StringTokenizer(br.readLine());
            arrX[Integer.parseInt(st.nextToken())] += 1;
            arrY[Integer.parseInt(st.nextToken())] += 1;
        }

        for (int i = 0; i < 1001; i++) {
            if (arrX[i] != 1) continue;
            sb.append(i).append(" ");
        }
        for (int i = 0; i < 1001; i++) {
            if (arrY[i] != 1) continue;
            sb.append(i);
        }
        System.out.println(sb);
    }
}
