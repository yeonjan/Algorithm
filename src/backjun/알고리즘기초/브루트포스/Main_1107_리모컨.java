package backjun.알고리즘기초.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1107_리모컨 {
    static int N, M;
    static boolean[] isBroken;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        isBroken = new boolean[10];
        int cnt = 0;

        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                isBroken[Integer.parseInt(st.nextToken())] = true;
            }
        }


        if (N != 100) {
            if (isOk(N)) {
                cnt = Math.min(justUpDown(), String.valueOf(N).length());
            } else {
                cnt = Math.min(justUpDown(), changeNUpDown());
            }
        }
        System.out.println(cnt);
    }

    public static int changeNUpDown() {
        int cnt = 0;
        int UP = N + 1;
        int DOWN = N - 1;
        for (int i = 0; i < 499900; i++) {
            cnt++;
            if (DOWN >= 0 && isOk(DOWN)) {
                cnt += String.valueOf(DOWN).length();
                break;
            }
            if (isOk(UP)) {
                cnt += String.valueOf(UP).length();
                break;
            }
            DOWN--;
            UP++;
        }

        return cnt;
    }

    public static int justUpDown() {
        return Math.abs(N - 100);
    }

    public static boolean isOk(int num) {
        String str = String.valueOf(num);

        for (int i = 0; i < str.length(); i++) {
            if (isBroken[str.charAt(i) - '0']) return false;
        }
        return true;
    }
}


