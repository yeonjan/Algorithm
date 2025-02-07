import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int ans = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> used = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{s, t});
        }

        while (!pq.isEmpty()) {
            int[] newClass = pq.poll();
            int[] canUse = used.peek();
            if (!used.isEmpty() && canUse[1] <= newClass[0]) {
                used.poll();
                used.add(newClass);
            } else {
                used.add(newClass);
            }

            ans = Math.max(ans, used.size());

        }
        System.out.println(ans);


    }

}
