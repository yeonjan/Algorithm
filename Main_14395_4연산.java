import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_14395_4연산 {
    static int s, t;
    static String[] opt = {"*", "+", "-", "/"};
    static boolean find;


    static class Node {
        int value;
        String opt;

        public Node(int value, String opt) {
            this.value = value;
            this.opt = opt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        if (s == t) System.out.println(0);
        else {
            bfs();
            if (!find) System.out.println(-1);
        }


    }

    public static void bfs() {
        ArrayList<Long> visited = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(new Node(s, ""));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                if (i == 3 && poll.value == 0) continue;

                long newValue = cla(poll.value, opt[i]);
                String newOpt = poll.opt + opt[i];

                if (newValue > t) continue;
                if (!visited.contains(newValue)) {
                    if (newValue == t) {
                        System.out.println(newOpt);
                        find = true;
                        return;
                    }
                    visited.add(newValue);
                    queue.offer(new Node((int) newValue, newOpt));
                }
            }
        }
    }
    public static long cla(long num, String opt) {
        switch (opt) {
            case "*":
                return num * num;
            case "+":
                return num + num;
            case "-":
                return num - num;
            default:
                return num / num;
        }
    }
}
