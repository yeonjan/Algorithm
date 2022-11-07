package study.공통문제;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;
        import java.util.Comparator;
        import java.util.PriorityQueue;
        import java.util.StringTokenizer;

public class Main_13904_과제 {
    static int N, sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return Integer.compare(o2[1], o1[1]);
                else return Integer.compare(o2[0], o1[0]);
            }
        });
        PriorityQueue<int[]> able = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
                else return Integer.compare(o2[1], o1[1]);
            }
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{d, w});
        }

        int day = pq.peek()[0] + 1;

        while (--day > 0) {
            while (!pq.isEmpty()&&pq.peek()[0] == day) {
                able.offer(pq.poll());
            }
            if (!able.isEmpty()) sum += able.poll()[1];

        }
        System.out.println(sum);
    }
}
