import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//dp배열에서 담고 있는 값의 의미가 무엇인지 정확하게 인지하고 풀기
//해당 문제에서는 dp는 start~end까지 페이지를 합치는데 드는 비용
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine());
            int[] file = new int[K + 1];
            int[] sum = new int[K + 1];
            int[][] dp = new int[K + 1][K + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= K; i++) {
                file[i] = Integer.parseInt(st.nextToken());
                sum[i] = file[i] + sum[i - 1];
            }



            for (int gap = 1; gap <= K; gap++) {
                for (int start = 1; start + gap <= K; start++) {
                    int end = start + gap;
                    dp[start][end] = Integer.MAX_VALUE;
                    for (int mid = start; mid < end; mid++) {
                        dp[start][end] = Math.min(dp[start][end], dp[start][mid] + dp[mid + 1][end] + sum[end] - sum[start - 1]);
                    }
                }
            }

            System.out.println(dp[1][K]);

        }


    }


}
