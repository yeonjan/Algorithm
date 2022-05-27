package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평균값구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += Integer.parseInt(st.nextToken());
            }
            sb.append("#").append(test_case).append(" ").append(Math.round((double) sum / 10)).append("\n");
        }
        System.out.println(sb);

    }
}
