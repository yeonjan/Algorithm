package backjun.단계별로풀어보기.단계11정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 좌표정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] points = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int[] p : points) {
            sb.append(p[0]).append(" ").append(p[1]).append("\n");
        }
        System.out.println(sb);

    }
}
