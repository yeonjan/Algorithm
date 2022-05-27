package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 패턴마다의길이 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int test = 1; test <= t; test++) {
            String str = br.readLine();
            String subStr1 = "";
            // find 마디
            for (int i = 0; i < 10; i++) {
                int index = i + 1;
                subStr1 = str.substring(0, index);
                String subStr2 = str.substring(index, index * 2);

                if (subStr1.equals(subStr2)) {
                    break;
                }
            }

            System.out.println("#" + test + " " + subStr1.length());

        }

    }

}
