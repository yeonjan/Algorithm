package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2170_선긋기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        // 선은 시작 위치를 기준으로 오름차순
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }


        int last = -1000000000; //선에서 마지막으로 그어진곳
        int length = 0; //선의 길이
        while (!pq.isEmpty()) {
            int[] line = pq.poll();

            //1. 중간에 띄우고 새로운 선을 긋는 경우 line[0]이 더 크다
            //2. 이미 그어진 선을 중복해서 긋는 경우 last가 더 크다
            int start = Math.max(line[0], last);
            int end = line[1];


            if (last >= end) continue;

            length += (end - start);
            last = end;
        }
        System.out.println(length);
    }
}
