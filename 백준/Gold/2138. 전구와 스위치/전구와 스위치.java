import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        boolean[] origin = new boolean[N];
        boolean[] target = new boolean[N];

        char[] input1 = br.readLine().toCharArray();
        char[] input2 = br.readLine().toCharArray();
        for (int i = 0; i < N; i++) {
            origin[i] = input1[i] == '0';
            target[i] = input2[i] == '0';
        }

        int ans1 = countSwitch(false, N, origin, target);
        int ans2 = countSwitch(true, N, origin, target);

        if (ans1 < 0) {
            System.out.println(ans2);
        } else if (ans2 < 0) {
            System.out.println(ans1);
        } else {
            System.out.println(Math.min(ans1, ans2));
        }


    }

    public static int countSwitch(boolean startState, int n, boolean[] input, boolean[] target) {
        boolean[] origin = Arrays.copyOf(input, n);
        int cnt = 0;
        if (startState) {
            cnt++;
            origin[0] = !origin[0];
            origin[1] = !origin[1];
        }


        for (int i = 0; i < n - 1; i++) {
            //스위치 온
            if (origin[i] != target[i]) {
                cnt++;
                origin[i] = !origin[i];
                origin[i + 1] = !origin[i + 1];
                if (i + 2 < n) {
                    origin[i + 2] = !origin[i + 2];
                }

            }
        }
        if (origin[n - 1] != target[n - 1]) {
            return -1;
        }

        return cnt;
    }


}
