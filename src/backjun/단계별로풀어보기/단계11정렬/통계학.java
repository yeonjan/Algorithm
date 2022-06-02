package backjun.단계별로풀어보기.단계11정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 통계학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        int sum = 0;

        for (int i = 0; i < n; ++i) {
            num[i] = Integer.parseInt(br.readLine());
            sum += num[i];
        }
        StringBuilder sb = new StringBuilder();

        //산술평균
        sb.append(Math.round((double) sum / n)).append("\n");

        //중앙값
        Arrays.sort(num);
        sb.append(num[n / 2]).append("\n");

        //최빈값
        int[] count = new int[8001];
        for (int i = 0; i < n; ++i) {
            count[num[i] + 4000] += 1;
        }
        int max = Arrays.stream(count).max().getAsInt();
        int result = 0;
        int cnt = 0;
        for (int i = 0; i < 8001; ++i) {
            if (cnt == 2) break;
            if (count[i] == max) {
                result = i - 4000;
                cnt++;
            }
        }
        sb.append(result).append("\n");

        //범위
        sb.append(num[n - 1] - num[0]).append("\n");


        System.out.println(sb);

    }
}
