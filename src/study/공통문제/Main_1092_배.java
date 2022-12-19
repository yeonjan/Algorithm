package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1092_배 {
    static int n, m, minute, cnt;
    static int[] cranes, boxes;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        cranes = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            cranes[i] = Integer.parseInt(input[i]);
        }

        m = Integer.parseInt(br.readLine());
        boxes = new int[m];
        input = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            boxes[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(cranes);
        Arrays.sort(boxes);

        if (cranes[n - 1] < boxes[m - 1]) System.out.println(-1);
        else {
            visited = new boolean[m];
            while (cnt < m) {
                //1min
                takeBox();
                minute++;
            }
            System.out.println(minute);
        }

    }

    public static void takeBox() {
        for (int j = n - 1; j >= 0; j--) {
            for (int i = m - 1; i >= 0; i--) {
                if (!visited[i] && cranes[j] >= boxes[i]) {
                    visited[i] = true;
                    cnt++;
                    break;
                }
            }
        }
    }
}
