package ssafy.수업.순열조합;

import java.util.Arrays;

public class 조합 {
    static int[] arr = {1, 2, 3, 4, 5};
    static int R = 3;
    static int N = 5;
    static int[] selected = new int[R];
    static boolean[] visited = new boolean[N+1];

    //5C3
    public static void main(String[] args) {
        //가장 작은 숫자로 정렬
        Arrays.sort(arr);

        combination(visited, 0);


    }

    public static void combination(boolean[] visited, int depth) {
        if (depth == R) {
            System.out.println(Arrays.toString(selected));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[arr[i]]) {
                visited[arr[i]] = true;
                selected[depth] = arr[i];
                combination(visited, depth + 1);
                selected[depth] = 0;
                visited[arr[i]] = false;
            }
        }

    }
}
