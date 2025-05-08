import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<List<int[]>> adj = new ArrayList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj.get(a).add(new int[]{b, c});
            adj.get(b).add(new int[]{a, c});
        }
        int[] minArr = dijkstra();
        System.out.println(minArr[N]);

    }

    public static int[] dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));//end,price
        int[] min = new int[N + 1];
        Arrays.fill(min, Integer.MAX_VALUE);

        pq.add(new int[]{1, 0});
        min[1] = 0;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int node = poll[0];
            int minVal = poll[1];

            if (minVal > min[node]) {
                continue;
            }

            for (int[] next : adj.get(node)) {
                int nextNode = next[0];
                int nextVal = next[1];
                if (minVal + nextVal < min[nextNode]) {
                    min[nextNode] = minVal + nextVal;
                    pq.add(new int[]{nextNode, minVal + nextVal});
                }

            }
        }

        return min;

    }


}


