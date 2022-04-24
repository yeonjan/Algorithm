package backjun.단계4배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평균 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] scores = new int[N];
        int max = -1;
        double sum = 0;

        for (int i = 0; i < N; ++i) {
            scores[i] = Integer.parseInt(st.nextToken());
            sum += scores[i];
            if (max < scores[i]) max = scores[i];
        }

        System.out.println(((sum / max) * 100) / N);
    }
}
