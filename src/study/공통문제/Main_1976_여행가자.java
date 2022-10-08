package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1976_여행가자 {

    static int[] parent;

    static int find(int a) {
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if (parentA != parentB) {
            int min = Math.min(parentA, parentB);
            parent[parentA] = min;
            parent[parentB] = min;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int connect = Integer.parseInt(st.nextToken());

                if (connect == 0 || i == j) continue;
                union(i, j);
            }
        }

        //확인하기 전에 parent가 모두 root를 향하도록
        for (int i = 1; i <= n; i++) {
            find(i);
        }

        st = new StringTokenizer(br.readLine());
        int r = find(Integer.parseInt(st.nextToken()));
        for (int i = 0; i < m - 1; i++) {
            if (find(Integer.parseInt(st.nextToken())) != r) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}

