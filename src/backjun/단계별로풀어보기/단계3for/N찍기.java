package backjun.단계별로풀어보기.단계3for;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N찍기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=1; i<=N;++i){
            System.out.println(i);
        }

    }
}
