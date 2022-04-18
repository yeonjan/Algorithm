package backjun.단계3for;

import java.io.*;
import java.util.StringTokenizer;

public class 빠른AB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int sum = a + b;

            bw.write(String.valueOf(sum));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
