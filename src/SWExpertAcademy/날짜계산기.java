package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 날짜계산기 {
    public static void main(String[] args) throws IOException {
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] day1 = new int[2];
        int[] day2 = new int[2];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            day1[0] = Integer.parseInt(st.nextToken());
            day1[1] = Integer.parseInt(st.nextToken());
            day2[0] = Integer.parseInt(st.nextToken());
            day2[1] = Integer.parseInt(st.nextToken());

            int count = 1;
            if (day1[0] == day2[0]) {
                count += day2[1] - day1[1];
            } else {
                for (int m = day1[0]; m <= day2[0]; m++) {
                    if (m == day1[0]) {
                        count += days[m] - day1[1];
                    } else if (m == day2[0]) {
                        count += day2[1];
                    } else {
                        count += days[m];
                    }
                }
            }

            System.out.println("#"+test_case+" "+count);

        }
    }
}
