import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        List<int[]>[] adj = new ArrayList[D + 1];

        for (int i = 0; i <= D; i++) {
            adj[i] = new ArrayList<>();
            if (i != D) adj[i].add(new int[]{i + 1, 1});

        }


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (b <= D && c < b - a) adj[a].add(new int[]{b, c});
        }
        int ans = dijkstra(N, D, adj);
        System.out.println(ans);


    }

    public static int dijkstra(int N, int D, List<int[]>[] adj) {
        int[] dist = new int[D + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));//next,d
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int node = poll[0];
            int min = poll[1];
            if (dist[node] < min) continue;
            dist[node] = min;

            for (int[] next : adj[node]) {
                int nextNode = next[0];

                int nextDist = next[1];

                if (min + nextDist < dist[nextNode]) {
                    pq.offer(new int[]{nextNode, min + nextDist});
                }
            }

        }
        return dist[D];

    }


}
