package ssafy.수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_3289_서로소집합 {
    static int n, m;
    static List<Node> list;

    static class Node {
        int parent;

        public Node(int p) {
            this.parent = p;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            list.add(new Node(0));
            for (int i = 1; i <= n; i++) {
                list.add(new Node(i));
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int op = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (op == 0) union(a, b);
                else if (op == 1) {
                    if (findSet(a) == findSet(b)) sb.append(1);
                    else sb.append(0);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);


    }

    public static void union(int a, int b) {
        int repA = findSet(a);
        int repB = findSet(b);
        list.get(repB).parent = repA;
    }

    public static int findSet(int a) {
        int p = list.get(a).parent;
        if (p == a) return a;
        else return list.get(a).parent = findSet(p);

    }

}