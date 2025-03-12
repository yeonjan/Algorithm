import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static int n, m;
    static int[][] adj;
    static int[] parent;
    static Set<Integer> route = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        adj = new int[n][n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
                if (adj[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            route.add(Integer.parseInt(st.nextToken()) - 1);
        }

        Set<Integer> root = new HashSet<>();
        for (int city : route) {
            root.add(find(city));
        }


        System.out.println(root.size()==1 ? "YES" : "NO");

    }

    public static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }


}