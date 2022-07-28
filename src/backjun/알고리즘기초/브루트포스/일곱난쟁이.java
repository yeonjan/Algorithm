package backjun.알고리즘기초.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일곱난쟁이 {
    static int[] dwarf = new int[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int gap = -100;

        for (int i = 0; i < 9; i++) {
            dwarf[i] = Integer.parseInt(br.readLine());
            gap += dwarf[i];
        }

        find:
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (dwarf[i] + dwarf[j] == gap) {
                    dwarf[i] = dwarf[j] = 100;
                    break find;
                }
            }
        }

        Arrays.sort(dwarf);

        for (int i = 0; i < 7; i++) {
            sb.append(dwarf[i]).append("\n");
        }
        System.out.println(sb);
    }
}
