package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class view {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n;
        int[] building;

        for (int i = 0; i < 10; ++i) {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            building = new int[n];
            for (int k = 0; k < n; ++k) {
                building[k] = Integer.parseInt(st.nextToken());
            }

            //check
            int total = 0;
            for (int now = 2; now < n - 2; now++) {
                int view;
                int temp;
                int left = 256;
                int right = 256;

                temp = Math.max(building[now - 1], building[now - 2]);
                if (building[now] > temp) {
                    left = building[now] - temp;
                }

                temp = Math.max(building[now + 1], building[now + 2]);
                if (building[now] > temp) {
                    right = building[now] - temp;
                }

                view = Math.min(left, right);
                if (Math.max(left, right) != 256) total += view;

            }
            sb.append("#").append(i+1).append(" ").append(total).append("\n");
        }

        System.out.println(sb);


    }
}
