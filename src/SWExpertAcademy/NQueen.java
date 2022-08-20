package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen {
    static int n;
    static int cnt;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        cnt = 0;
        arr = new int[n];
        dfs(0);
        System.out.println(cnt);

    }

    public static void dfs(int depth) {
        if (depth == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[depth] = i;
            if (possible(depth)) {
                dfs(depth + 1);
            }
        }
    }

    public static boolean possible(int row) {

        for (int i = 0; i < row; i++) {
            if (arr[row] == arr[i]) {
                return false;
            } else if (Math.abs(row - i) == Math.abs(arr[row] - arr[i])) { //대각선에 있으면//가로세로 이동량 같음
                return false;
            }

        }
        return true;

    }
}
