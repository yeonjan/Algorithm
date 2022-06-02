package backjun.단계별로풀어보기.단계4배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] value = String.valueOf(Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine())).toCharArray();
        int[] count = new int[10];
        StringBuilder sb = new StringBuilder();

        for (char c : value){
            for (int i =0;i<10;i++){
                if((c-'0')==i) count[i]+=1;
            }

        }

        for(int num : count){
            sb.append(num).append("\n");
        }
        System.out.println(sb.toString());
    }
}
