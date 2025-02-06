import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n, k;
    static int MAX = 100000;
    static int[] min = new int[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= MAX; i++) {
            min[i] = Integer.MAX_VALUE;
        }

        bfs();
        System.out.println(min[k]);


    }

    public static void bfs() {
        min[n] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{n, 0});
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int pos = poll[0];
            int time = poll[1];

            if (pos - 1 >= 0 && min[pos - 1] > time + 1) {
                pq.add(new int[]{pos - 1, time + 1});
                min[pos - 1] = time + 1;
            }
            if (pos + 1 <= MAX && min[pos + 1] > time + 1) {
                pq.add(new int[]{pos + 1, time + 1});
                min[pos + 1] = time + 1;
            }
            if (pos * 2 <= MAX && min[pos * 2] > time + 1) {
                pq.add(new int[]{pos * 2, time + 1});
                min[pos * 2] = time + 1;
            }
        }

    }


}