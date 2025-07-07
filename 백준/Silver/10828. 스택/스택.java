import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class MyStack<T> {
        ArrayList<T> list = new ArrayList<>();

        public void push(T data) {
            list.add(data);
        }

        public void pop() {
            if (list.isEmpty()) {
                System.out.println(-1);
                return;
            }
            System.out.println(list.get(list.size() - 1));
            list.remove(list.size() - 1);
        }

        public void size() {
            System.out.println(list.size());
        }

        public void empty() {
            System.out.println(list.isEmpty() ? 1 : 0);
        }

        public void top() {
            if (list.isEmpty()) {
                System.out.println(-1);
                return;
            }
            System.out.println(list.get(list.size() - 1));
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        MyStack<String> stack = new MyStack<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "push":
                    stack.push(input[1]);
                    break;
                case "pop":
                    stack.pop();
                    break;
                case "size":
                    stack.size();
                    break;
                case "empty":
                    stack.empty();
                    break;
                case "top":
                    stack.top();
                    break;
            }
        }


    }


}

