import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n, m, x;
    static int ans = 0;
    static int[] dist;
    static List<List<int[]>> adj = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        dist = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj.get(a).add(new int[]{b, c});
        }

        int[] min = new int[n + 1];
        findDistance(min, x);
        for (int i = 1; i <= n; i++) {
            if (i == x) continue;
            dist[i] += min[i];
        }

        for (int i = 1; i <= n; i++) {
            if (i == x) continue;
            findDistance(min, i);
            dist[i] += min[x];
            ans = Math.max(ans, dist[i]);
        }
        System.out.println(ans);


    }

    public static void findDistance(int[] min, int start) {
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int i = 1; i <= n; i++) {
            min[i] = Integer.MAX_VALUE;
        }
        pq.offer(new int[]{start, 0});
        min[start] = 0;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int v = poll[0];
            int dist = poll[1];
            visited[v] = true;

            for (int[] next : adj.get(v)) {
                int nextV = next[0];
                int nextDist = next[1];
                if (visited[nextV]) continue;

                if (min[nextV] > dist + nextDist) {
                    min[nextV] = dist + nextDist;
                    pq.offer(new int[]{nextV, dist + nextDist});
                }

            }


        }

    }


}