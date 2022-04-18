package backjun.단계3while;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ApB5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while (!(input = br.readLine()).equals("0 0")) {
            String[] value = input.split(" ");
            int a = Integer.parseInt(value[0]);
            int b = Integer.parseInt(value[1]);
            System.out.println(a + b);
        }
    }
}
