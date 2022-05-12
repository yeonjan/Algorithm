package backjun.단계10브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 덩치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] people = new int[n][2];

        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            people[i][0] = Integer.parseInt(st.nextToken());
            people[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int stand = 0; stand < n; ++stand) {
            int cnt = 1;

            for (int comp = 0; comp < n; ++comp) {
                if (comp == stand) continue;
                if (people[comp][0] > people[stand][0] && people[comp][1] > people[stand][1]) {
                    cnt++;
                }
            }
            sb.append(cnt).append(" ");
        }

        System.out.println(sb);
    }
}
