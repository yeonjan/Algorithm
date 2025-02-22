import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, x, ans = 0;
    static List<List<int[]>> adj = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

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

        int[] minX = new int[n + 1];
        findDistance(minX, x);  // x에서 모든 정점까지의 거리

        for (int i = 1; i <= n; i++) {
            if (i == x) continue;
            int[] minI = new int[n + 1];
            findDistance(minI, i);  // i에서 x까지의 거리
            ans = Math.max(ans, minI[x] + minX[i]);
        }
        System.out.println(ans);
    }

    public static void findDistance(int[] min, int start) {
        Arrays.fill(min, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});
        min[start] = 0;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int v = poll[0], dist = poll[1];

            if (dist > min[v]) continue;  // 더 짧은 경로가 이미 갱신되었으면 스킵

            for (int[] next : adj.get(v)) {
                int nextV = next[0], nextDist = next[1];
                if (min[nextV] > dist + nextDist) {
                    min[nextV] = dist + nextDist;
                    pq.offer(new int[]{nextV, min[nextV]});
                }
            }
        }
    }
}