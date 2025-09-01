import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<List<long[]>> adj = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            adj.get(s).add(new long[]{e, i});
            adj.get(e).add(new long[]{s, i});
        }
        long result = solve(adj, n, m);

        System.out.println(result);
    }

    public static long solve(List<List<long[]>> adj, int n, int m) {
        long[] min = new long[n + 1];
        Arrays.fill(min, Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[1]));
        pq.offer(new long[]{1, 0});
        min[1] = 0;

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int area = Math.toIntExact(cur[0]);
            long time = cur[1];
            for (long[] next : adj.get(area)) {
                int nextArea = Math.toIntExact(next[0]);
                long nextTime = getNextTime(next[1], m, time);

                if (nextTime < min[nextArea]) {
                    min[nextArea] = nextTime;
                    pq.add(new long[]{nextArea, nextTime});
                }
            }
        }

        return min[n];
    }

    public static long getNextTime(long t, int m, long from) {

        long sleep = from / m;
        long t2 = from % m;

        if (t2 <= t) {
            return m * sleep + t;
        } else {
            return m * (sleep + 1) + t;
        }
    }

}
