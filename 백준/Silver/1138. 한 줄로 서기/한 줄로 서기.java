import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] leftCount = new int[N + 1];
        int[] ans = new int[N];
        for (int i = 1; i <= N; i++) {
            leftCount[i] = Integer.parseInt(st.nextToken());

        }

        for (int i = 1; i <= N; i++) {
            int idx = 0;
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (cnt == leftCount[i]) {
                    idx = j;
                    break;
                }
                if (ans[j] == 0) cnt++;

            }


            for (int j = idx; j <= N; j++) {
                if (ans[j] == 0) {
                    ans[j] = i;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb.toString());


    }


}