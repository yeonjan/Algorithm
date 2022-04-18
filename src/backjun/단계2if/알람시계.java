package backjun.단계2if;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 알람시계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input =br.readLine().split(" ");
        int H = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        StringBuilder sb = new StringBuilder();

        if (M < 45) {
            M+=60;
            H-=1;
        }
        if (H<0){
            H+=24;
        }
        M-=45;

        sb.append(H).append(" ").append(M);
        System.out.println(sb.toString());


    }
}
