package backjun.단계별로풀어보기.단계7기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 손익분기점 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int fixed = Integer.parseInt(st.nextToken());
        int variable = Integer.parseInt(st.nextToken());
        int price = Integer.parseInt(st.nextToken());
        int BEP=0;
        if(variable>=price){
            BEP=-1;
        }else{
            BEP=fixed/(price-variable)+1;
        }
        System.out.println(BEP);
    }
}
