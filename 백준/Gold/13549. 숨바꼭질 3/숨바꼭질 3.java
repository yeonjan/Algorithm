import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n, k;
    static int MAX = 200000;
    static int[] minTime = new int[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Arrays.fill(minTime, Integer.MAX_VALUE);
        bfs();
        System.out.println(minTime[k]);


    }

    public static void bfs() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1])
        );
        pq.offer(new int[]{n, 0});
        minTime[n] = 0;

        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            int num = info[0];
            int time = info[1];

            if (num - 1 >= 0 && minTime[num - 1] > time + 1) {
                minTime[num - 1] = time + 1;
                pq.offer(new int[]{num - 1, time + 1});
            }

            if (num + 1 <= MAX && minTime[num + 1] > time + 1) {
                minTime[num + 1] = time + 1;
                pq.offer(new int[]{num + 1, time + 1});
            }

            if (num * 2 <= MAX && minTime[num * 2] > time) {
                minTime[num * 2] = time;
                pq.offer(new int[]{num * 2, time});
            }

        }

    }


}