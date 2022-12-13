package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1202_보석도둑 {
    static int n, k;
    static long ans;
    static int[] bag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bag = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[0], o2[0]));


        //보석 pq에 넣기
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            pq.offer(new int[]{Integer.parseInt(input[0]), Integer.parseInt(input[1])});
        }

        //배낭 입력 받기
        for (int i = 0; i < k; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bag);

        //특정 가방에 들어가는 보석의 값만 담고 있음
        PriorityQueue<Integer> value = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1, o2));

        for (int c : bag) {

            while (!pq.isEmpty()) {
                if (pq.peek()[0] <= c) {
                    value.offer(pq.poll()[1]);
                } else break;
            }
            if (!value.isEmpty()) ans += value.poll();
        }

        System.out.println(ans);

    }
}
