package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 선수과목 {
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static int n;
    static int result;
    static boolean isNo;
    static int count;

    @SuppressWarnings("unchecked")
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int test = 1; test <= t; test++) {
            // 입력&변수
            n = Integer.parseInt(br.readLine());
            result = 0;
            visit = new boolean[n + 1];
            graph = new ArrayList[n + 1];
            for (int i = 0; i < n + 1; i++) {
                graph[i] = new ArrayList<>();
            }

            // 선수과목 입력
            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int cnt = Integer.parseInt(st.nextToken());
                for (int c = 0; c < cnt; c++) {
                    graph[i].add(Integer.parseInt(st.nextToken()));
                }
            }

            // dfs

            result = n+1;
            dfs(1, 1, 1);
            if (result == 0)
                result = -1;
            System.out.println("#" + test + " " + result);

        }
    }

    public static void dfs(int at, int depth, int count) {
        visit[at] = true;
        if(depth==n) {
            result=Math.min(result, depth);
        }
        for (int g : graph[at]) {
            // System.out.println("g"+g);
            if (!visit[g]) {
                dfs(g, depth + 1, count + 1);
                visit[g] = false;
            }

        }

    }

}
