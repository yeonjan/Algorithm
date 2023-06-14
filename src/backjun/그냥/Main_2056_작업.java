package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2056_작업 {
    static int n;

    static int[] time;
    static boolean[] end;
    static int[] input;
    static ArrayList<Integer>[] nextTask;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        nextTask = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            nextTask[i] = new ArrayList<>();
        }

        time = new int[n + 1];
        end = new boolean[n + 1];
        input = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            input[i] = cnt;
            for (int p = 0; p < cnt; p++) {
                int num = Integer.parseInt(st.nextToken());
                nextTask[num].add(i);
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));//[작업 번호,끝나는 시간]
        int now = -1;
        while (!isEnd()) {
            now++;
            //끝난 작업 visited 처리
            while (!pq.isEmpty() && pq.peek()[1] <= now) {
                int[] poll = pq.poll();
                end[poll[0]] = true;
                for (int next : nextTask[poll[0]]) {
                    input[next]--;
                }

            }

            //수행 가능한 작업 큐에 넣기
            for (int i = 1; i <= n; i++) {
                if (input[i] == 0) {
                    input[i] = -1;
                    pq.offer(new int[]{i, now + time[i]});
                }
            }
        }
        System.out.println(now);

    }

    public static boolean isEnd() {
        for (int i = 1; i <= n; i++) {
            if (!end[i]) return false;
        }
        return true;
    }

}
//작업 큐 -> 현재 작업중인 작업(끝나는 시간 오름차순)
//후행 -> 선행1, 선행2
// 1 (5)
// 2 (1) -> 1