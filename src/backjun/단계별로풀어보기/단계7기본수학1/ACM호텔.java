package backjun.단계별로풀어보기.단계7기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ACM호텔 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int h = (N - 1) % H + 1;
            int w = (N - 1) / H + 1;

            System.out.println((h * 100) + w);
        }
    }
}
