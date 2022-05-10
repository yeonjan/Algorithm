package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백만장자프로젝트 {
    static int[] salePrice;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; ++i) {
            int n = Integer.parseInt(br.readLine());
            salePrice = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < n; k++) salePrice[k] = Integer.parseInt(st.nextToken());
            System.out.println(String.format("#%d ",i+1)+calculate(n));
        }
    }
    public static long calculate(int n) {
        long money = 0;
        int max = 0;
        for (int i = n-1; i >= 0; --i) {
            if (salePrice[i] > max) max = salePrice[i];
            else {
                money += (max - salePrice[i]);
            }
        }
        return money;
    }
}
