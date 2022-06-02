package backjun.단계별로풀어보기.단계3for;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 구구단 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=1;i<10;++i){
            sb.append(N).append(" * ").append(i).append(" = ").append(N*i).append("\n");
        }

        System.out.println(sb.toString());

    }
}