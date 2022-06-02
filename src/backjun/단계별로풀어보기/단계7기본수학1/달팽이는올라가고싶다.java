package backjun.단계별로풀어보기.단계7기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 달팽이는올라가고싶다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int oneTime = A - B;

        int day = (int) Math.ceil((double) (V-A)/oneTime);
        System.out.println(day+1);

    }
}
