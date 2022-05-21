package backjun.단계11정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 좌표정렬하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] points = new int[n][2];
        String[] point;
        for (int i = 0; i < n; ++i) {
            point = br.readLine().split(" ");
            points[i][0] = Integer.parseInt(point[0]);
            points[i][1] = Integer.parseInt(point[1]);
        }

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        StringBuilder sb =new StringBuilder();
        for(int[] p : points){
            sb.append(p[0]).append(" ").append(p[1]).append("\n");
        }
        System.out.println(sb);
    }
}
