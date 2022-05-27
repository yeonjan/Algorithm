package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 연월일달력 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        for (int test_case = 1; test_case <= T; test_case++) {

            String result;
            String input = br.readLine();
            String year = input.substring(0, 4);
            int month = Integer.parseInt(input.substring(4, 6));
            int day = Integer.parseInt(input.substring(6, 8));

            if (month > 12 || month < 1) {
                result = "-1";
            } else if (day > days[month - 1] || day < 1) {
                result = "-1";
            } else {
                result = String.format("%s/%02d/%02d", year, month, day);
            }
            System.out.println("#" + test_case + " " + result);

        }
    }

}
