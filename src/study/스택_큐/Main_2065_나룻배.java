package study.스택_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_2065_나룻배 {
    static int M, t, N, cnt;
    static int time, ferry;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        LinkedList<int[]> left = new LinkedList<>();
        LinkedList<int[]> right = new LinkedList<>();

        M = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        answer = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int arrivalTime = Integer.parseInt(st.nextToken());
            String dock = st.nextToken();

            if (dock.equals("left")) left.offer(new int[]{arrivalTime, i});
            else if (dock.equals("right")) right.offer(new int[]{arrivalTime, i});
        }


        while (!left.isEmpty() || !right.isEmpty()) {
            //ferry == 0 -> left
            loadAndMove(ferry == 0 ? left : right, ferry == 0 ? right : left);

        }

        for (int a : answer) {
            sb.append(a + "\n");
        }
        System.out.println(sb.toString());

    }

    public static void justMove() {
        time += t;
        ferry = ferry == 0 ? 1 : 0;
    }

    public static void loadAndMove(LinkedList<int[]> queueFrom, LinkedList<int[]> queueTo) {
        cnt = 0;
        //현재 있는 정박장에 더이상 손님 x
/*        if (queueFrom.isEmpty()) {
            justMove();
            return;
        }*/

        //현재정박장에 손님이 이미있는 경우
        while (!queueFrom.isEmpty() && cnt < M && queueFrom.peek()[0] <= time) {
            int[] cur = queueFrom.poll();
            answer[cur[1]] = time + t;
            cnt++;
        }
        if (cnt != 0) {
            justMove();
            return;
        }
        //현재 정박장에서 손님을 기다려야 하는 경우
        if (queueFrom.isEmpty()) {
            time = Math.max(queueTo.peek()[0], time);
            justMove();
        } else if (queueTo.isEmpty() || queueFrom.peek()[0] <= queueTo.peek()[0]) {
            time = Math.max(queueFrom.peek()[0], time);
        } else if (queueFrom.peek()[0] > queueTo.peek()[0]) {
            time = Math.max(queueTo.peek()[0], time);
            justMove();
        }
    }
}

