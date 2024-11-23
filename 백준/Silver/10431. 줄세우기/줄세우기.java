import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1, o2));

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int total = 0;
            pq.clear();
            st = new StringTokenizer(br.readLine());
            sb.append(st.nextToken()).append(" ");
            PriorityQueue<Integer> temp = new PriorityQueue<>();
            for (int i = 0; i < 20; i++) {
                int height = Integer.parseInt(st.nextToken());
                if (pq.isEmpty()) {
                    pq.add(height);
                    continue;
                }

                //키가 더 크면
                while (!pq.isEmpty() && pq.peek() > height) {
                    temp.add(pq.poll());
                    total++;
                }
                while (!temp.isEmpty()) {
                    pq.add(temp.poll());
                }
                pq.add(height);
            }
            sb.append(total).append("\n");

        }
        System.out.println(sb);

    }


}