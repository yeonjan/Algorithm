package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_1655_가운데를말해요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> under = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> over = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        int mid = Integer.parseInt(br.readLine());
        sb.append(mid).append("\n");

        for (int i = 1; i < n; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input > mid) {
                over.offer(input);
                if (over.size() - under.size() > 1) {
                    under.offer(mid);
                    mid = over.poll();
                }
            } else {
                under.offer(input);
                if (over.size() - under.size() < 0) {
                    over.offer(mid);
                    mid = under.poll();
                }
            }
            sb.append(mid).append("\n");
        }
        System.out.println(sb);

    }
}
