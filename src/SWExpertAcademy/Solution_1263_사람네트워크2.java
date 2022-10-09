package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1263_사람네트워크2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            //입력 & 그래프 초기화
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] adj = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    adj[i][j] = Integer.parseInt(st.nextToken());
                    if (adj[i][j] == 0 && i != j) adj[i][j] = 1000;
                }
            }
            //플로이드 워셜
            for (int num = 0; num < n; num++) {
                for (int i = 0; i < n; i++) {
                    if (i == num) continue;
                    for (int j = 0; j < n; j++) {
                        if (j == num || i == j) continue;

                        adj[i][j] = Math.min(adj[i][j], adj[i][num] + adj[num][j]);
                    }
                }
            }
            //cc값 구하기
            int cc = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int temp = 0;
                for (int j = 0; j < n; j++) {
                    temp += adj[i][j];
                }
                cc = Math.min(cc, temp);
            }
            sb.append("#" + t + " " + cc).append("\n");
        }
        System.out.println(sb);
    }
}
