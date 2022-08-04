package ssafy.과제._0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2164_카드2 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        boolean remove = true;
        while (queue.size() != 1) {
            if (remove) {
                queue.poll();
                remove = false;
            } else {
                queue.offer(queue.poll());
                remove = true;
            }
        }
        System.out.println(queue.poll());

    }
}
