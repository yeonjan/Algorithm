import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        n = Integer.parseInt(br.readLine());
        int count = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            pq.offer(new int[]{x, y});
            max = Math.max(max, x);
        }
        pq.offer(new int[]{max + 1, 0});

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int height = node[1];

            if (stack.peek() < height) {
                stack.push(height);
            } else if(stack.peek() > height){
                Integer lastNum = stack.pop();
                count++;
                while (!stack.isEmpty() && stack.peek() > height) {
                    Integer pop = stack.pop();
                    if (lastNum > pop) {
                        lastNum = pop;
                        count++;
                    }
                }
                stack.push(height);
            }
        }
        System.out.println(count);

    }

}
