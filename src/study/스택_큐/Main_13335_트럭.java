package study.스택_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_13335_트럭 {
    static int n, w, L;
    static int[] truck;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Integer> queue = new LinkedList<>();

        int sum = 0;
        int time = 0;
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        truck = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            truck[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0, idx = 0; i < w * n + 1; i++) {
            if (queue.size() >= w) {
                sum -= queue.poll();
            }

            if (idx < n && sum + truck[idx] <= L) {
                int next = truck[idx];
                queue.offer(next);
                sum += next;
                idx++;
            } else {
                queue.offer(0);
            }
            time++;

            if (sum == 0) break;
        }

        System.out.println(time);
    }
}
