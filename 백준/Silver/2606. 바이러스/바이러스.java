import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static boolean[][] adj;
    static boolean[] visited;
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        adj = new boolean[size + 1][size + 1];
        visited=new boolean[size + 1];
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a][b] = true;
            adj[b][a] = true;
        }
        visited[1]=true;
        System.out.println(dfs(1)-1);


    }

    public static int dfs(int idx) {
        int cnt = 1;
        for (int i = 1; i <= size; i++) {
            if (i == idx) continue;
            if (!visited[i]&&adj[idx][i]) {
                visited[i] = true;
                cnt += dfs(i);
            }
        }
        return cnt;
    }


}