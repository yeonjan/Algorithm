import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int size = 0;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        int[] countArr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            if (i != 0) countArr[i] = countArr[i - 1];
            if (input[i] == 'b') {
                size++;
                countArr[i]++;
            }
        }
        if (size == 0) {
            System.out.println(0);
            return;
        }
        int countB = countArr[size - 1];
        ans = countB;
        for (int i = 1; i < input.length; i++) {
            int left = i - 1;
            int right = (i + size - 1 ) % input.length;
            if (input[left] == 'b') {
                countB--;
            }
            if (input[right] == 'b') {
                countB++;
            }
            if (countB > ans) ans = countB;
        }
        System.out.println(size - ans);

    }

}