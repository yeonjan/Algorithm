package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최대상금 {
    static StringBuilder sb = new StringBuilder();
    static int result;
    static int[] arr;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; ++i) {
            //입력 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            count = Integer.parseInt(st.nextToken());

            arr = new int[num.length()];
            String[] temp = num.split("");
            for (int k = 0; k < arr.length; ++k) {
                arr[k] = Integer.parseInt(temp[k]);
            }

            result = 0;
            dfs(0, 0);
            sb.append("#").append(i + 1).append(" ").append(result).append("\n");
        }
        System.out.println(sb);

    }

    public static void dfs(int depth, int move) {
        int max = 0;
        for (int a : arr) max = Math.max(a, max);

        if (move == count) {
            String temp = Arrays.toString(arr).replaceAll("[^0-9]", "");
            //System.out.println(temp);
            result = Math.max(result, Integer.parseInt(temp));
            return;
        }

        for (int i = depth; i < arr.length - 1; i++) {
            for (int k = i + 1; k < arr.length; k++) {
                if (arr[i] <= arr[k]) {
                    //교환
                    int temp = arr[k];
                    arr[k] = arr[i];
                    arr[i] = temp;

                    dfs(i, move + 1);

                    //원래대로
                    temp = arr[k];
                    arr[k] = arr[i];
                    arr[i] = temp;
                } else if (arr[0]==max) {
                    //교환
                    int temp = arr[k];
                    arr[k] = arr[i];
                    arr[i] = temp;

                    dfs(i, move + 1);

                    //원래대로
                    temp = arr[k];
                    arr[k] = arr[i];
                    arr[i] = temp;
                }
            }

        }

    }
}
