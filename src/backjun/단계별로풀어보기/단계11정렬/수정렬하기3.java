package backjun.단계별로풀어보기.단계11정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] countingArr = new int[10000001];

        for (int i = 0; i < n; ++i) {
            countingArr[Integer.parseInt(br.readLine())] += 1;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10000001; ++i) {
            while (countingArr[i]!=0){
                sb.append(i).append("\n");
                countingArr[i]--;
            }
        }
        System.out.println(sb);
    }
}
