package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 간단한압축풀기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            String[] c = new String[n];
            int[] k = new int[n];
            int size = 0;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                c[i] = st.nextToken();
                k[i] = Integer.parseInt(st.nextToken());
                size += k[i];
            }
            String[] arr = new String[size];
            int idx=0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < k[i]; j++) {
                    arr[idx+j] = c[i];
                }
                idx+=k[i];
            }
            //print
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append("\n");
            for (int i = 0; i < size; i++) {
                sb.append(arr[i]);
                if ((i + 1) % 10 == 0) sb.append("\n");

            }
            System.out.println(sb);
        }
    }

}
