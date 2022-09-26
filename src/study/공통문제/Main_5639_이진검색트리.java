package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_5639_이진검색트리 {

    static List<Integer> values = new ArrayList<>();

    static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int n) {
            if (n < this.value) {
                if (this.left == null) this.left = new Node(n);
                else this.left.insert(n);
            } else {
                if (this.right == null) this.right = new Node(n);
                else this.right.insert(n);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));
        String input = "";


        while ((input = br.readLine()) != null && !input.isEmpty()) {
            root.insert(Integer.parseInt(input));
        }

        postOrder(root);


    }

    public static void postOrder(Node node) {
        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }
}
