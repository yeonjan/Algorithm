package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2281_데스노트 {
    static int[] dp; //dp[idx] : idx 위치의 이름이 첫 줄에서 시작할 때, (해당 줄부터 줄에 남은 칸)^2이 최소인 값
    static int[] name; // 입력으로 들어오는 이름의 길이
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dp = new int[n];
        name = new int[n];

        //이름의 길이 입력으로 받음
        for (int i = 0; i < n; i++) {
            name[i] = Integer.parseInt(br.readLine());
        }

        dp[n - 1] = 0; //마지막 줄은 항상 0
        //최종적으로 dp[0]을 구해야함 -> 뒤에서부터 메모이제이션
        for (int idx = n - 2; idx >= 0; idx--) {
            int min = Integer.MAX_VALUE;

            //1. 한줄에 idx 번째 이름만 존재
            min = (int) Math.min(min, Math.pow(m - name[idx], 2) + dp[idx + 1]);


            //2. 한줄에 idx ~ i번째 이름까지 붙여 쓸 경우
            int space = m - name[idx]; //한줄에 남은 여백의 수

            for (int i = idx + 1; i < n; i++) {
                space -= name[i] + 1;

                //여백이 없다면 못쓰는 거 -> 탐색 중지
                if (space < 0) break;

                //마지막 줄인 경우
                if (i == n - 1) {
                    min = 0;
                    break;
                }

                min = (int) Math.min(min, Math.pow(space, 2) + dp[i + 1]);
            }

            dp[idx] = min;
        }
        System.out.println(dp[0]);
    }
}
