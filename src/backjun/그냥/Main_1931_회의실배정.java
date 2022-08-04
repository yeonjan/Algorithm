package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1931_회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int endTime = -1;
        int cnt = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
            else return Integer.compare(o1[1], o2[1]);
        });

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            queue.offer(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        for (int i = 0; i < n; i++) {
            if (queue.peek()[0] < endTime) {
                queue.poll();
            } else {
                endTime = queue.poll()[1];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
