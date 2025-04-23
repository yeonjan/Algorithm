import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 셋중 하나
        // 1. 주식 하나 구매
        // 2. 원하는 만큼 주식을 판다.
        // 3. 아무것도 안한다

        // 10 7 6
        //규칙 오른다면 사고
        //내린다면 팔아라!!
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            long[] dayPrice = new long[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                dayPrice[i] = Long.parseLong(st.nextToken());
            }
            System.out.println(getMax(dayPrice));


        }


    }

    public static long getMax(long[] dayPrice) {
        long profit = 0;
        long[] futurePrice = getFuturePrice(dayPrice);
        for (int i = 0; i < futurePrice.length; i++) {
            if (futurePrice[i] > dayPrice[i]) {
                profit += futurePrice[i] - dayPrice[i];
            }
        }


        return profit;

    }

    private static long[] getFuturePrice(long[] dayPrice) {
        long[] futurePrice = new long[dayPrice.length]; // 시간이 지나고 max

        long max = 0;
        for (int i = dayPrice.length - 1; i >= 0; i--) {
            max = Math.max(max, dayPrice[i]);
            futurePrice[i] = max;
        }
        return futurePrice;
    }


}