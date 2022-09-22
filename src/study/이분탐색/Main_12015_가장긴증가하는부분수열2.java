package study.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_12015_가장긴증가하는부분수열2 {
    static int lastIndex, target, low, high, mid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> lis = new ArrayList<>();
        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        lis.add(a[0]);

        for (int i = 1; i < n; i++) {
            lastIndex = lis.size() - 1;
            target = a[i];

            //lis의 마지막 값보다 큰 경우 그냥 추가
            if (target > lis.get(lastIndex)) lis.add(target);
            else {
                low = 0;
                high = lastIndex;

                while (low < high) {
                    mid = (low + high) / 2;

                    if (lis.get(mid) >= target) high = mid;
                    else low = mid + 1;
                }

                lis.set(low, target);
            }
        }

        System.out.println(lis.size());

    }
}
