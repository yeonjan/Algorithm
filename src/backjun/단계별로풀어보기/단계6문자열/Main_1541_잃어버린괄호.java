package backjun.단계별로풀어보기.단계6문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_1541_잃어버린괄호 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder num = new StringBuilder();
        List<Integer> nums = new ArrayList<>();
        List<String> opt = new ArrayList<>();
        int plus = 0;
        int minus = 0;

        char[] input = br.readLine().toCharArray();

        for (char i : input) {
            //숫자
            if (i >= 48) {
                num.append(i);
            } else {
                nums.add(Integer.valueOf(num.toString()));
                num.setLength(0);
                opt.add(String.valueOf(i));
            }
        }
        nums.add(Integer.valueOf(num.toString()));

        int idx = 25;
        for (int i = 0; i < opt.size(); i++) {
            if (opt.get(i).equals("-")) {
                idx = i;
                break;
            }
        }

        for (int i = 0; i < nums.size(); i++) {
            if (i > idx) minus += nums.get(i);
            else plus += nums.get(i);
        }
        System.out.println(plus-minus);
    }
}
