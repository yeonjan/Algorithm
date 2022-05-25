package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Flatten {
    static int[] box = new int[100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int b = 0; b < 100; b++) {
                box[b] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(box);
            for (int i = 0; i < n; i++) {
                dump();
                Arrays.sort(box);
            }
            System.out.println("#" + t + " " + (box[99] - box[0]));
        }
    }

    public static void dump() {
        box[99] -= 1;
        box[0] += 1;
    }
}
