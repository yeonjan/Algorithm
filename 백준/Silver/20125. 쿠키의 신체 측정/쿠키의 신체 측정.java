import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;
    static boolean[][] map;
    static int[][] delta = {{0, -1}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new boolean[N][N];
        boolean foundHead = false;
        int[] heart = new int[2];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                if (input.charAt(j) == '*') {
                    if (!foundHead) {
                        heart = new int[]{i+1, j};
                        foundHead = true;
                    }
                    map[i][j] = true;
                }
            }
        }
        int leftArm = getLength(new int[]{heart[0], heart[1] - 1}, 0);
        int rightArm = getLength(new int[]{heart[0], heart[1] + 1}, 1);
        int body = getLength(new int[]{heart[0] + 1, heart[1]}, 2);
        int leftLeg = getLength(new int[]{heart[0] + body + 1, heart[1] - 1}, 2);
        int rightLeg = getLength(new int[]{heart[0] + body + 1, heart[1] + 1}, 2);
        System.out.println((heart[0] + 1) + " " + (heart[1] + 1));
        System.out.println(leftArm + " " + rightArm + " " + body + " " + leftLeg + " " + rightLeg);


    }

    public static int getLength(int[] start, int d) {
        int cnt = 0;
        int dr = start[0];
        int dc = start[1];
        while (!check(dr, dc) && map[dr][dc]) {
            cnt++;
            dr += delta[d][0];
            dc += delta[d][1];
        }
        return cnt;

    }

    public static boolean check(int dr, int dc) {
        return dr < 0 || dc < 0 || dr >= N || dc >= N;
    }


}