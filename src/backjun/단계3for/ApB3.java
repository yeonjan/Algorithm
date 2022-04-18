package backjun.단계3for;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ApB3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i =0;i<T;++i){
            String[] value = br.readLine().split(" ");
            System.out.println(Integer.parseInt(value[0])+Integer.parseInt(value[1]));
        }
    }
}
