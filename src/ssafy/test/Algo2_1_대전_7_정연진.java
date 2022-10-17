package ssafy.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo2_1_대전_7_정연진 {
    static int T, V, P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        //최대V인 20까지 팩토리얼 계산
        long[] fact = new long[21];
        fact[0] = 1;
        for (int i = 1; i <= 20; i++) {
            fact[i] = fact[i - 1] * i;
        }

        //테스트케이스 T만큼 반복
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            //V,P 입력
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            //조합 구하기
            long result = fact[V] / (fact[P] * fact[V - P]);
            //스트링 빌더에 결과 추가
            sb.append("#" + t + " " + result).append("\n");
        }
        //출력
        System.out.println(sb.toString());

    }

}
