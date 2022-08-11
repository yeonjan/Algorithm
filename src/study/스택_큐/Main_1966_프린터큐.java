package study.스택_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1966_프린터큐 {
    static int N, M, print;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            print = 0;

            LinkedList<int[]> queue = new LinkedList<>();
            PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int cur = Integer.parseInt(st.nextToken());
                queue.offer(new int[]{cur, i});
                max.offer(cur);

            }

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();

                if (cur[0] == max.peek()) {
                    max.poll();
                    print++;
                    if (cur[1] == M) break;
                } else if (cur[0] < max.peek()) queue.offer(cur);
            }
            sb.append(print + "\n");

        }
        System.out.println(sb);
    }
}
