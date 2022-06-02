package backjun.단계별로풀어보기.단계1입출력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나머지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A=Integer.parseInt(st.nextToken());
        int B=Integer.parseInt(st.nextToken());
        int C=Integer.parseInt(st.nextToken());

        System.out.println((A+B)%C);
        System.out.println( ((A%C) + (B%C))%C);
        System.out.println((A*B)%C);
        System.out.println( ((A%C)*(B%C))%C);
    }
}
