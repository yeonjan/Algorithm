package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 날짝계산기2 {
    public static void main(String[] args) throws IOException {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] startDay = new int[2];
        int[] endDay = new int[2];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            startDay[0] = Integer.parseInt(st.nextToken());
            startDay[1] = Integer.parseInt(st.nextToken());
            endDay[0] = Integer.parseInt(st.nextToken());
            endDay[1] = Integer.parseInt(st.nextToken());

            int count = 1;
            for (int i = 0; i < endDay[0] - 1; i++) {
                count += days[i];
            }
            count += endDay[1];

            for (int i = 0; i < startDay[0] - 1; i++) {
                count -= days[i];
            }
            count -= startDay[1];

            System.out.println("#" + test_case + " " + count);

        }
    }
}
