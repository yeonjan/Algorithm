package backjun.단계1입출력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 곱셈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int a= Integer.parseInt(br.readLine());
        String b= br.readLine();
        int sum=0;

        char[] value = b.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = value.length-1 ;i >=0;--i){
            int temp = Integer.parseInt(String.valueOf(value[i]))*a;
            sb.append(temp).append("\n");
            sum += temp*Math.pow(10,value.length-1-i);
        }
        sb.append(sum);
        System.out.println(sb.toString());

    }
}
