package backjun.단계별로풀어보기.단계11정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 수정렬하기2 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>();

        for (int i = 0; i < n; ++i) {
            que.add(Integer.valueOf(br.readLine()));
        }

        while(!que.isEmpty()){
            sb.append(que.poll()).append("\n");
        }
        System.out.println(sb);
    }
}
