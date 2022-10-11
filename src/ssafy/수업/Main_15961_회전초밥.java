package ssafy.수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15961_회전초밥 {
    static int n, d, k, c, ans = 0;
    static int[] visited, arr, isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        visited = new int[d + 1];
        arr = new int[n];
        isSelected = new int[k];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());

        int l = 0;
        int r = 0;
        int cnt = 0;
        while (l < n) {
            //오른쪽 이동
            int sushi = arr[r % n];
            if (sushi != c && visited[sushi] == 0) cnt++;
            visited[sushi]++;
            r++;


            if (Math.abs(r - l) == k) {
                //k개 선택 후 값 업데이트
                ans = Math.max(ans, cnt);

                //왼쪽 이동
                int leftSushi = arr[l];
                visited[leftSushi]--;
                if (leftSushi != c && visited[leftSushi] == 0) cnt--;
                l++;
            }
            if (l == r) break;

        }
        System.out.println(ans + 1);

    }
}
