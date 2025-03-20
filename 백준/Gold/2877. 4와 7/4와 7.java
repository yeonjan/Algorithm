import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int k;
    static int[] input = {4, 7};
    static int order = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        int digit = getDigit();
        int[] result = new int[digit];
        int bound = (int) Math.pow(2, digit);
        for (int i = 0; i < digit; i++) {
            bound/=2;
            if (bound >= order) result[i] = input[0];
            else {
                result[i] = input[1];
                order-= bound;
            }
        }
        print(result);


    }


    public static void print(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        System.out.println(sb.toString());
    }

    public static int getDigit() {
        int digit = 1;
        int sum = 0;
        while (sum + (int) Math.pow(2, digit) < k) {
            sum += (int) Math.pow(2, digit);
            digit++;
        }

        order = k - sum;
        return digit;
    }
}
