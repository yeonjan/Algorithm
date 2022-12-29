package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2473_세용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 용액의 수
        long min = Long.MAX_VALUE; // 0에 가장 가까운 특성값
        long[] ans = new long[3]; // 정답인 세용액
        long[] sol = new long[n]; // 입력으로 들어오는 모든 용액

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sol[i] = Integer.parseInt(st.nextToken());
        }

        //순차적으로 탐색하기 위해 정렬
        Arrays.sort(sol);

        //세용액 i,l,r
        FIND_ZERO:
        for (int i = 0; i < n; i++) {
            int l = i + 1;
            int r = n - 1;

            while (l < r) {
                long sum = sol[i] + sol[l] + sol[r];

                //세용액을 더한값의 절댓값이 최소라면
                if (min > Math.abs(sum)) {
                    min = Math.abs(sum);
                    ans[0] = sol[i];
                    ans[1] = sol[l];
                    ans[2] = sol[r];
                }

                if (sum < 0) l++;
                else if (sum > 0) r--;
                else break FIND_ZERO;
            }
        }

        System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
    }
}
