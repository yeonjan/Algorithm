package backjun.단계7기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 큰수AB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = new StringBuffer(st.nextToken()).reverse().toString();
        String b = new StringBuffer(st.nextToken()).reverse().toString();
        int length_max = Math.max(a.length(), b.length());
        int length_min = Math.min(a.length(), b.length());
        int temp = 0;

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length_min; ++i) {
            int sum = a.charAt(i) + b.charAt(i) + temp - 2 * '0';
            result.append(sum % 10);
            temp = sum / 10;

        }
        for (int i = length_min; i < length_max; ++i) {
            if (a.length() > b.length()) {
                int sum = a.charAt(i) + temp - '0';
                result.append(sum % 10);
                temp = sum / 10;
            } else if (a.length() < b.length()) {
                int sum = b.charAt(i) + temp - '0';
                result.append(sum % 10);
                temp = sum / 10;
            }
        }
        if (temp != 0) result.append(temp);

        System.out.println(result.reverse());
    }
}
