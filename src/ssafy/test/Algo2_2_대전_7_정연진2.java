package ssafy.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo2_2_대전_7_정연진2 {
    static int T, V, P, L, ans;
    static int[] city;
    static int[][] dist;
    static int[] isSelect;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        //테스트 케이스만큼 반복
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            //V,P,L입력
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            //마을 정보 입력받아 배열에 저장
            city = new int[V];
            dist = new int[V][V];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < V; i++) {
                city[i] = Integer.parseInt(st.nextToken());
            }

            //각 마을간의 거리를 이차원 배열에 저장
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (i == j) continue;
                    if (dist[i][j] != 0) continue;

                    int abs = Math.abs(city[i] - city[j]);
                    dist[i][j] = Math.min(abs, L - abs);
                }
            }

            //선택된 경찰서를 담을 배열 선언
            isSelect = new int[P];
            //최소거리를 담은 변수 선언
            ans = Integer.MAX_VALUE;
            //조합을 구하는 함수 실행
            comb(0, 0);
            //해당 테스트 케이스의 결과 저장
            sb.append("#" + t + " " + ans + "\n");
        }
        //출력
        System.out.println(sb);

    }

    public static void comb(int cnt, int start) {
        //P개를 선택한경우 거리를 계산하고 종료
        if (cnt == P) {
            int sum = 0;
            //i=모든 마을, s= 경찰서
            for (int i = 0; i < V; i++) {
                int temp = Integer.MAX_VALUE;
                for (int s : isSelect) {
                    temp = Math.min(dist[i][s], temp);
                }
                //더 가까운 경찰서 거리를 업데이트
                sum += temp;
            }
            ans = Math.min(ans, sum);
            return;
        }
        //V개의 마을 중에서 선택한 마을을 isSelect에 저장
        for (int i = start; i < V; i++) {
            isSelect[cnt] = i;
            comb(cnt + 1, i + 1);
        }
    }

}
