import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int t = 0; t < 3; t++) {
            int n = Integer.parseInt(br.readLine());
            List<int[]> coins = new ArrayList<>();
            coins.add(new int[]{0, 0});
            int sum = 0;
            //동전 금액, 개수
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int price = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                sum += (price * cnt);
                coins.add(new int[]{price, cnt});

            }

            if (sum % 2 == 1) sb.append(0).append("\n");
            else sb.append(solve(coins, sum / 2) ? 1 : 0).append("\n");


        }
        System.out.println(sb.toString());


    }

    public static boolean solve(List<int[]> coins, int sum) {

        boolean[][] dp = new boolean[coins.size()][sum + 1];// 동전 i까지 이용해 j원을 만들 수 있는지
        dp[0][0] = true;

//        dp[i-1][0~j]까지 탐색했을 때 true -> dp[i][j*개수] true;


        for (int j = 0; j <= sum; j++) {
            for (int i = 1; i < coins.size(); i++) {
                int[] coin = coins.get(i);
                if (dp[i - 1][j]) {
                    for (int k = 0; k <= coin[1]; k++) {
                        if (j + (k * coin[0]) <= sum) dp[i][j + (k * coin[0])] = true;
                    }
                }
            }

        }

        return dp[coins.size()-1 ][sum];
    }


}

