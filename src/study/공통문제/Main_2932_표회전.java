package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2932_표회전 {
    static int n, k;

    static int[] x = new int[1000], posR = new int[1000], posC = new int[1000];
    static int[] targetR = new int[1000], targetC = new int[1000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());


        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            targetR[i] = Integer.parseInt(st.nextToken())-1;
            targetC[i] = Integer.parseInt(st.nextToken())-1;

            posR[i] = (x[i] - 1) / n;
            posC[i] = (x[i] - 1) % n;

        }

        for (int i = 0; i < k; i++) {
            int cntR = targetR[i] - posR[i];
            int cntC = targetC[i] - posC[i];
            if (cntR < 0) cntR += n;
            if (cntC < 0) cntC += n;

            rotateRow(posR[i], cntC);
            rotateCol(posC[i], cntR);
            sb.append(cntR + cntC).append("\n");
        }
        System.out.println(sb);

    }

    public static void rotateRow(int r, int cnt) {
        for (int i = 0; i < k; i++) {
            if (posR[i] == r) {
                posC[i] = (posC[i] + cnt) % n;
            }
        }
    }

    public static void rotateCol(int c, int cnt) {
        for (int i = 0; i < k; i++) {
            if (posC[i] == c) {
                posR[i] = (posR[i] + cnt) % n;
            }
        }
    }
}
