package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1043_거짓말 {
    static int N, M, ans;
    static LinkedList<Integer> queue = new LinkedList<>();
    static int[][] party;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        party = new int[M + 1][N + 1];
        ans = M;


        st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        for (int i = 0; i < cnt; i++) {
            int person = Integer.parseInt(st.nextToken());
            queue.offer(person);
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt2 = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt2; j++) {
                int person = Integer.parseInt(st.nextToken());
                party[i][person] = 1;
            }
        }

        while (!queue.isEmpty()) {
            Integer knowPerson = queue.poll();

            if (party[0][knowPerson] == 1) continue;

            party[0][knowPerson] = 1;
            for (int i = 1; i <= M; i++) {
                //진실을 아는 사람이 참여한 파티
                if (party[i][knowPerson] == 1 && party[i][0] != 1) {
                    ans--;
                    party[i][0] = 1;
                    for (int j = 1; j <= N; j++) {
                        if (party[0][j] != 1 && party[i][j] == 1) {
                            queue.offer(j);
                        }
                    }
                }
            }
        }

        System.out.println(ans);

    }
}
