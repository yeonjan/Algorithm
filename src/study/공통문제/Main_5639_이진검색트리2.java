package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_5639_이진검색트리2 {

    static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));
        String input;


        while ((input = br.readLine()) != null && !input.isEmpty()) {
            insert(root, Integer.parseInt(input));
        }

        postOrder(root);


    }

    public static void postOrder(Node node) {
        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }

    public static void insert(Node node, int n) {
        if (n < node.value) {
            if (node.left == null) node.left = new Node(n);
            else insert(node.left, n);
        } else {
            if (node.right == null) node.right = new Node(n);
            else insert(node.right, n);
        }

    }
}
