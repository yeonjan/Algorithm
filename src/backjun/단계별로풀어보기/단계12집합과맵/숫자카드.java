package backjun.단계별로풀어보기.단계12집합과맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[20000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[Integer.parseInt(st.nextToken()) + 10000000] = 1;
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            if(cards[Integer.parseInt(st.nextToken()) + 10000000]==1) sb.append(1+" ");
            else sb.append(0+" ");
        }

        System.out.println(sb);
    }
}
