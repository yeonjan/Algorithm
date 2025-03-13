import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static int n;
    static int ans = 0;
    static int[] buildings;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        buildings = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        for (int a = 0; a < n; a++) {
//            System.out.println("building = " + a);
            int count = 0;
            for (int b = 0; b < n; b++) {
                if (a == b) continue;
                if (canSee(a, b)) {
//                    System.out.print(b + " ");
                    count++;
                }
            }

//            System.out.println();
//            System.out.println(count);

            ans = Math.max(ans, count);
        }
        System.out.println(ans);


    }

    private static boolean canSee(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        int lowIdx;
        if (buildings[a] <= buildings[b]) {
            lowIdx = a;
        } else lowIdx = b;

        double ratio = getRatio(a, b);
        for (int i = min + 1; i < max; i++) {
            if (buildings[i] < buildings[lowIdx]) continue;
            double r = getRatio(i, lowIdx);
            if (r >= ratio) {
                return false;
            }

        }
        return true;
    }

    public static double getRatio(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        int w = max - min;
        int h = Math.abs(buildings[a] - buildings[b]);
        return (double) h / (double) w;
    }


}