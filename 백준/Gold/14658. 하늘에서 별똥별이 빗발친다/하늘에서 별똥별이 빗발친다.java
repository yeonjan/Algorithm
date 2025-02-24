import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n, m, l, k;
    static int ans = 0;
    static List<int[]> stars = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stars.add(new int[]{x, y});
        }

        for (int[] star1 : stars) {
            for (int[] star2 : stars) {
                ans = Math.max(ans, countStars(star1[0], star2[1]));
            }
        }
        System.out.println(k - ans);


    }

    public static int countStars(int r, int c) {
        int count = 0;
        for (int[] star : stars) {
            if (r <= star[0] && star[0] <= r + l && c <= star[1] && star[1] <= c + l) {
                count++;
            }
        }
        return count;
    }


}