import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    static int[] nums = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};


    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        setDp(dp);
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            String max = findMax(input);
            System.out.println(dp[input] + " " + max);
        }

    }

    public static void setDp(long[] dp) {
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[1] = 9;
        dp[2] = 1;
        dp[3] = 7;
        dp[4] = 4;
        dp[5] = 2;
        dp[6] = 6;
        dp[7] = 8;

        for (int x = 8; x <= 100; x++) {
            for (int i = 2; i <= 7; i++) {
                dp[x] = Math.min(dp[x], dp[x - i] * 10 + (i!=6?dp[i]:0));
            }
        }

    }


    public static String findMax(int cnt) {
        StringBuilder sb = new StringBuilder();
        if (cnt % 2 == 1 && cnt >= nums[7]) {
            sb.append("7");
            cnt -= nums[7];
        }
        while (cnt > 0) {
            sb.append("1");
            cnt -= nums[1];
        }
        return sb.toString();


    }

    public static void findMin() {

    }


}