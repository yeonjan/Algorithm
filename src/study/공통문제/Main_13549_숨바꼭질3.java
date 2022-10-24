package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_13549_숨바꼭질3 {

    static int N, K, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if (N != K) bfs();
        System.out.println(ans);

    }

    public static void bfs() {
        int max = 150000;
        int[] visited = new int[max + 1];
        for (int i = 0; i <= max; i++) {
            visited[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]);
            } else {
                return Integer.compare(o1[1], o2[1]);

            }
        });
        pq.add(new int[]{N, 0});


        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int pos = poll[0];
            int time = poll[1];
            if (poll[0] == K) {
                ans = poll[1];
                break;
            }

            if (pos != 0 && pos * 2 <= max && visited[pos * 2] > time) {
                pq.add(new int[]{pos * 2, time});
                visited[pos * 2] = time;
            }

            if (pos > 0 && visited[pos - 1] > poll[1] + 1) {
                pq.add(new int[]{pos - 1, time + 1});
                visited[pos - 1] = time + 1;
            }
            if (pos + 1 <= max && visited[pos + 1] > time + 1) {
                pq.add(new int[]{pos + 1, time + 1});
                visited[pos + 1] = time + 1;
            }

        }
    }
}
