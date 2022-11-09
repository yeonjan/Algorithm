package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2250_트리의높이와너비 {
    static int n, root, idx = 1, maxDepth, ans = 0, level;
    static int[] width;
    static boolean[] parent;
    static Node[] tree;

    static class Node {
        int num, left, right;

        public Node(int num, int left, int right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        parent = new boolean[n + 1];
        width = new int[n + 1];
        tree = new Node[n + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if (l > 0) parent[l] = true;
            if (r > 0) parent[r] = true;
            tree[n] = new Node(n, l, r);
        }

        for (int i = 1; i <= n; i++) {
            if (!parent[i]) root = i;
        }

        search(root, 0);

        for (int i = 1; i <= maxDepth; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int w = 1; w <= n; w++) {
                if (width[w] == i) {
                    min = Math.min(min, w);
                    max = Math.max(max, w);
                }
            }
            if (max - min + 1 > ans) {
                ans = max - min + 1;
                level = i;
            }

        }
        System.out.println(level + " " + ans);

    }

    public static void search(int nodeNum, int depth) {
        maxDepth = Math.max(depth+1, maxDepth);
        Node node = tree[nodeNum];

        //왼쪽
        if (node.left > 0) search(node.left, depth + 1);

        //루트
        width[idx++] = depth + 1;

        //오른쪽
        if (node.right > 0) search(node.right, depth + 1);

    }

}
