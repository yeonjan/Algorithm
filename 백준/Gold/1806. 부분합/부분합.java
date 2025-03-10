import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n, s;
    static int min = Integer.MAX_VALUE;
    static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        sum = new int[n + 1];
        sum[0] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int input = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + input;

        }

        int left = 1;
        int right = 1;
        while (left <= right) {

            int total = sum[right] - sum[left - 1];
            if (total >= s) {
                min = Math.min(min, right - left + 1);
                left++;
            } else if(right<n) {
                right++;
            }else{
                left=right+1;
            }
        }
        System.out.println(min==Integer.MAX_VALUE?0:min);


    }

}