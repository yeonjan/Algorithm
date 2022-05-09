package backjun.단계8기본수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class 터렛 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[] point1 = new int[3];
        int[] point2 = new int[3];

        for (int i = 0; i < t; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < 3; k++) point1[k] = Integer.parseInt(st.nextToken());
            for (int k = 0; k < 3; k++) point2[k] = Integer.parseInt(st.nextToken());

            double d = sqrt(pow(point2[0] - point1[0], 2) + pow(point2[1] - point1[1], 2));
            int sum = point1[2] + point2[2];
            int diff = abs(point2[2] - point1[2]);

            //두원이 두점에서 만남
            if (diff < d && d < sum) {
                System.out.println(2);
            }
            //두 원이 동일
            else if (d == 0 && diff == 0) {
                System.out.println(-1);
            }
            //두원이 외접 또는 내접
            else if (d == sum || d == diff) {
                System.out.println(1);
            }
            //만나지 않음
            else System.out.println(0);
        }
    }
}
