package backjun.단계3반복문;

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
