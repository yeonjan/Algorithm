package backjun.단계11정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 소트인사이드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char[] num = input.toCharArray();
        Arrays.sort(num);

        StringBuilder sb = new StringBuilder(new String(num));
        System.out.println(sb.reverse());
    }
}
