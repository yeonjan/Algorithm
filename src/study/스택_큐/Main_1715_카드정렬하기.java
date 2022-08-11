package study.스택_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1715_카드정렬하기 {
    static int N, compare, A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            queue.offer(Integer.valueOf(br.readLine()));
        }

        while (queue.size() > 1) {
            A = queue.poll();
            B = queue.poll();
            compare += (A + B);
            queue.offer(A + B);

        }
        System.out.println(compare);
    }
}

//더미 10+20 +40+50 -> 뺀 카드 추가
//비교 10+20 +30+40+ 70+50; -> 더미+새로뺀 카드

//