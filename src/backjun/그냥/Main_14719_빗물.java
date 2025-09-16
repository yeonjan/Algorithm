package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_14719_빗물 {
    static int H, W;
    static int[] block;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        block = new int[W + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            block[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 1; i < W - 1; i++) {
            int left = 0, right = 0;
            for (int j = 0; j < i; j++) {
                left = Math.max(left, block[j]);
            }
            for (int j = i + 1; j < W; j++) {
                right = Math.max(right, block[j]);
            }
            int wall = Math.min(left, right);
            if (wall > block[i]) {
                sum += wall - block[i];
            }
        }

        System.out.println(sum);


    }
}

