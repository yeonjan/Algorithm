package ssafy.수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_17471_게리맨더링 {
    static int n, ans = Integer.MAX_VALUE;
    static int[] population;
    static boolean[] visited, check;
    static boolean isPossible;
    static List<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        population = new int[n + 1];
        adj = new List[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            population[i] = Integer.parseInt(st.nextToken());
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                adj[i].add(Integer.valueOf(st.nextToken()));
            }
        }

        for (int i = 1; i <= n / 2; i++) {
            visited = new boolean[n + 1];
            comb(0, 1, i);
        }
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

    }

    public static void comb(int cnt, int start, int size) {
        if (cnt == size) {
            check = new boolean[n + 1];

            int sum1 = bfs(true);
            int sum2 = bfs(false);
            for (int i = 1; i <= n; i++) {
                if (!check[i]) return;
            }
            ans = Math.min(Math.abs(sum1 - sum2), ans);
            return;
        }
        for (int i = start; i <= n; i++) {
            visited[i] = true;
            comb(cnt + 1, i + 1, size);
            visited[i] = false;
        }
    }


    public static int bfs(boolean type) {
        int sum = 0;


        for (int i = 1; i <= n; i++) {
            if (visited[i] == type) {
                LinkedList<Integer> queue = new LinkedList<>();
                queue.add(i);
                check[i] = true;

                while (!queue.isEmpty()) {
                    Integer poll = queue.poll();
                    sum += population[poll];
                    for (int a : adj[poll]) {
                        if (!check[a] && visited[a] == type) {
                            check[a] = true;
                            queue.add(a);
                        }
                    }
                }
                break;
            }
        }

        return sum;
    }


}
