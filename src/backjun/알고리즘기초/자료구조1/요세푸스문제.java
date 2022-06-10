package backjun.알고리즘기초.자료구조1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 요세푸스문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        LinkedList<Integer> deque = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            deque.offer(i);
        }

        int cnt = 0, idx = 0;
        String[] output = new String[n];

        while (!deque.isEmpty()) {
            cnt++;
            if (cnt == k) {
                output[idx++] = String.valueOf(deque.poll());
                cnt = 0;
            } else deque.offer(deque.poll());
        }

        String answer = String.join(", ", output);
        System.out.println("<" + answer + ">");

    }
}
