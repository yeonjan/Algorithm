package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10453_문자열변환 {
    static int T;
    static char[] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int ans = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            A = st.nextToken().toCharArray();
            B = st.nextToken().toCharArray();

            int size = A.length;

            for (int idx = 0; idx < size; idx++) {
                //해당 위치에서 두 문자가 같다면 탐색하지 않음
                if (A[idx] == B[idx]) continue;


                //바꿀 문자가 있는지 탐색
                for (int i = idx + 1; i < size; i++) {
                    if (A[i] == B[idx]) {
                        for (int j = i; j > idx; j--) {
                            char temp = A[j];
                            A[j] = A[j - 1];
                            A[j - 1] = temp;
                            ans++;
                        }
                        break;
                    }
                }
            }
            sb.append(ans + "\n");
        }
        System.out.println(sb);
    }
}
