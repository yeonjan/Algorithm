package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 최빈수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int idx = Integer.parseInt(br.readLine());
            String[] score = br.readLine().split(" ");
            int[] count = new int[101];
            for (String s : score) {
                count[Integer.parseInt(s)] += 1;
            }

            int max = 0;
            int result = 0;
            for (int k = 0; k < count.length; k++) {
                if (count[k] >= max) {
                    max = count[k];
                    result = k;
                }
            }
            System.out.println("#" + idx + " " + result);
        }


    }
}
