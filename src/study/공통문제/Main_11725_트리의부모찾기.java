package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main_11725_트리의부모찾기 {
    static int[] parents;
    static int n;
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        parents = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        bfs();

        for (int i=2;i<=n;i++){
            System.out.println(parents[i]);
        }


    }

    public static void bfs() {
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        boolean[] visited = new boolean[n + 1];
        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            Integer p = queue.poll();

            for (Integer child : adj.get(p)) {
                if (!visited[child]) {
                    visited[child] = true;
                    queue.offer(child);
                    parents[child] = p;
                }
            }
        }
    }
}
