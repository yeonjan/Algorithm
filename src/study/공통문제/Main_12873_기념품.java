package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main_12873_기념품 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        int round = 1;
        int last = 0;
        while (!queue.isEmpty()) {
            long size = (long) ((Math.pow(round, 3)) % queue.size());
            if (size == 0) size = queue.size();
            for (int i = 0; i < size - 1; i++) {
                queue.offer(queue.poll());
            }
            last = queue.poll();
            round++;
        }
        System.out.println(last);


    }
}
