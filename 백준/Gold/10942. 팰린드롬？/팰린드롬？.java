import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//시간 초과 예상
public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, M;
        int[][] dp;
        int[] nums;

        N = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][N + 1];
        nums = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        //1 2 1 3 1 2 1

        for (int i = 1; i <= N; i++) {
            dp[i][i] = 1;
            for (int gap = 1; 0 < i - gap && i + gap <= N; gap++) {
                if (nums[i - gap] == nums[i + gap]) {
                    dp[i - gap][i + gap] = 1;
                } else {
                    break;
                }
            }
            //짝수
            if (i + 1 <= N && nums[i] == nums[i + 1]) {
                dp[i][i + 1] = 1;
                for (int gap = 1; 0 < i - gap && i + 1 + gap <= N; gap++) {
                    if (nums[i - gap] == nums[i + 1 + gap]) {
                        dp[i - gap][i + 1 + gap] = 1;
                    } else {
                        break;
                    }
                }
            }
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            sb.append(dp[S][E]).append("\n");
        }
        System.out.println(sb.toString());


    }


}