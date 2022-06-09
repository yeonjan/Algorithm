package backjun.알고리즘기초.자료구조1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class 큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        LinkedList<String> queue = new LinkedList<>();

        for (int t = 0; t < n; t++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "push":
                    queue.offer(input[1]);
                    break;

                case "pop":
                    sb.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
                    break;

                case "size":
                    sb.append(queue.size()).append("\n");
                    break;

                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                    break;

                case "front":
                    sb.append(queue.isEmpty() ? -1 : queue.peek()).append("\n");
                    break;

                case "back":
                    sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb);

    }
}
