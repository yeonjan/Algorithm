package backjun.알고리즘기초.자료구조1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> stack = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    num = Integer.parseInt(st.nextToken());
                    stack.add(num);
                    break;

                case "pop":
                    if (stack.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else {
                        num = stack.remove(stack.size() - 1);
                        sb.append(num + "\n");
                    }
                    break;

                case "size":
                    sb.append(stack.size() + "\n");
                    break;

                case "empty":
                    if (stack.isEmpty()) {
                        sb.append(1 + "\n");
                    } else {
                        sb.append(0 + "\n");
                    }
                    break;
                case "top":
                    if (stack.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else {
                        num = stack.get(stack.size() - 1);
                        sb.append(num + "\n");
                    }
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
