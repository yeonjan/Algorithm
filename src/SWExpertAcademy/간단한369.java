package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 간단한369 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            String target = String.valueOf(i);
            cnt += count369(target, '3');
            cnt += count369(target, '6');
            cnt += count369(target, '9');
            if(cnt!=0){
                sb.append("-".repeat(cnt)).append(" ");
            }else{
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    public static int count369(String i, char num) {
        int cnt = 0;
        if (i.contains(String.valueOf(num))) {
            for (int k = 0; k < i.length(); k++) {
                if (i.charAt(k) == num) cnt++;
            }
        }
        return cnt;
    }
}
