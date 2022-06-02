package backjun.단계별로풀어보기.단계3for;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ApB7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; ++i) {
            String[] value = br.readLine().split(" ");
            int sum = Integer.parseInt(value[0])+Integer.parseInt(value[1]);
            System.out.println(String.format("Case #%d: %d",i,sum));
        }

    }
}
