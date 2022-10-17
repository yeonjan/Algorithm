package ssafy.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo1_대전_7_정연진 {
    static int N, S, M, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        //N, S, M 입력
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //신청한 동아리의 수 만큼 반복
        for (int i = 0; i < N; i++) {
            //3명의 능력치 입력받아 배열에 저장
            String[] input = br.readLine().split(" ");
            //능력치의 합을 저장할 변수
            int sum = 0;
            //3명중 능력치가 M을 넘지 못하는 사람이 있을경우 저장하지 않는다
            for (int j = 0; j < 3; j++) {
                int x = Integer.parseInt(input[j]);
                if (x >= M) sum += x;
                else break;
            }
            //능력치합이 S를 넘을 경우 결과 sb에 저장
            if (sum >= S) {
                cnt++;
                for (int j = 0; j < 3; j++) {
                    sb.append(input[j] + " ");
                }
            }
        }
        System.out.println(cnt);
        System.out.println(sb.toString());

    }
}
