package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1911_흙길보수하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq = new PriorityQueue<>((Comparator.comparingInt(o -> o[0])));
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int[] pool = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            pq.offer(pool);
        }

        int cover = 0;
        int totalCnt = 0;
        while (!pq.isEmpty()) {
            int cnt = 0;
            int[] poll = pq.poll();
            if (poll[1] <= cover) continue;

            int start = Math.max(cover, poll[0]);
            int range = poll[1] - start;
            cnt += range / l;
            if (range % l > 0) cnt += 1;
            cover = start + (cnt * l);
            totalCnt += cnt;
        }
        System.out.println(totalCnt);

    }
}
