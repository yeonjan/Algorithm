package backjun.단계별로풀어보기.단계2if;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 두수비교하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        String comp;

        if (a>b){
            comp=">";
        } else if(a<b){
            comp="<";
        } else{
            comp="==";
        }
        System.out.println(comp);

    }
}
