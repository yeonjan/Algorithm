import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1, o2));
        PriorityQueue<Integer> right = new PriorityQueue<>();
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (i == 0) {
                left.add(num);
                sb.append(left.peek()).append("\n");
                continue;
            }

            if (!left.isEmpty() && left.peek() > num) {
                left.add(num);
            } else {
                right.add(num);
            }

            //균형
            while ((left.size() - (i % 2 == 1 ? 0 : 1)) != right.size()) {
                if (left.size() > right.size()) {
                    right.add(left.poll());
                } else {
                    left.add(right.poll());
                }
            }
            sb.append(left.peek()).append("\n");
        }
        System.out.println(sb.toString());
    }


}


