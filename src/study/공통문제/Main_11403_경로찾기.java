package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11403_경로찾기 {
    static int n;
    static int[][] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        adj = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                adj[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (adj[i][k] + adj[k][j] > 1) {
                        adj[i][j] = 1;
                    }
                }
            }

        }
        //출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(adj[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
