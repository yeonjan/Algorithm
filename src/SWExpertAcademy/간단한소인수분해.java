package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 간단한소인수분해 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] num = {2, 3, 5, 7, 11};

        for (int test_case = 1; test_case <= T; test_case++) {
            StringBuilder temp = new StringBuilder();
            int[] result = new int[5];
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < 5; i++) {
                while ((double) n % num[i] == 0) {
                    n /= num[i];
                    result[i] += 1;
                }
                temp.append(result[i]).append(" ");
            }
            System.out.println("#" + test_case+" " + temp);


        }
    }
}
