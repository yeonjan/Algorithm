import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n, m, v;
    static boolean[] visit;
    static List<List<Integer>> adj = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        visit = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        for (int i = 0; i <= n; i++) {
            adj.get(i).sort(Comparator.naturalOrder());
        }


        dfs(v);
        sb.append("\n");
        bfs(v);

        System.out.println(sb);


    }

    public static void dfs(int idx) {
        visit[idx] = true;
        sb.append(idx).append(" ");


        for (int a : adj.get(idx)) {
            if (!visit[a]) {
                dfs(a);
            }

        }
    }

    public static void bfs(int idx) {
        Queue<Integer> queue = new ArrayDeque<>();
        visit = new boolean[n + 1];
        visit[idx] = true;
        queue.offer(idx);
        while (!queue.isEmpty()) {
            Integer num = queue.poll();
            sb.append(num).append(" ");
            for (int a : adj.get(num)) {
                if (!visit[a]) {
                    visit[a] = true;
                    queue.offer(a);
                }
            }
        }
    }

}