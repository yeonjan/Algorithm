package backjun.단계별로풀어보기.단계3while;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ApB4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        while ((input = br.readLine()) != null) {
            String[] value = input.split(" ");
            int A= Integer.parseInt(value[0]);
            int B= Integer.parseInt(value[1]);
            System.out.println(A+B);
        }
    }
}
