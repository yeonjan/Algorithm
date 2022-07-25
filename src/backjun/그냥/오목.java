package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class 오목 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[][] delta = {{0, 1}, {1, 0}, {1, 1}, {-1, 1}};
        int[][] countRow = new int[3][20];
        int[][] map = new int[21][21];
        int[] answer = new int[2];
        boolean[] omock = new boolean[3];

        //map 입력과 각 행의 검은돌, 흰돌 수 카운트
        for (int i = 1; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 20; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) countRow[1][i]++;
                if (map[i][j] == 2) countRow[2][i]++;
            }
        }

        //i==1 검은돌, i==2 흰돌
        for (int i = 1; i <= 2; i++) {
            //오목이 완성되면 더이상 행 탐색 x
            stop:
            for (int h = 1; h < 20; h++) {
                // h행에 검은돌 or 흰돌이 없으면 pass
                if (countRow[i][h] == 0) continue;

                // h행에 검은돌 or 흰돌이 있으면 실행
                for (int w = 1; w < 20; w++) {
                    int now = map[h][w];

                    //현재 탐색중인 돌이 검은돌 or 흰돌
                    if (now == i) {
                        check:
                        for (int idx = 0; idx < 4; idx++) { //가로,세로,오른쪽대각,왼쪽대각
                            int cnt = 1;
                            //-1번째 값과 6번째 체크
                            for (int c = -1; c <= 5; c += 6) {
                                int check_h = h + delta[idx][0] * c;
                                int check_w = w + delta[idx][1] * c;
                                if (check_h < 20 && check_w < 20 && check_h > 0 && check_w > 0 && map[check_h][check_w] == i)
                                    continue check;

                            }
                            //s=4까지 오목인지 확인 + s=5는 돌이 6개 이상인지 확인용
                            for (int s = 1; s < 5; s++) {
                                int H = h + delta[idx][0] * s;
                                int W = w + delta[idx][1] * s;
                                if (H < 20 && W < 20 && H > 0 && W > 0 && map[H][W] == i) cnt++;
                            }
                            //오목이면!!
                            if (cnt == 5) {
                                answer[0] = h;
                                answer[1] = w;
                                omock[i] = true;
                            }
                        }
                        //오목이 완성되면 더이상 행 탐색 x
                        if (omock[i]) break stop;
                    }

                }
            }
        }
        //무승부, 검은돌 승, 흰돌 승
        if (omock[1] == omock[2]) System.out.println("0");
        else if (omock[1]) {
            System.out.println("1");
            System.out.println(answer[0] + " " + answer[1]);
        } else {
            System.out.println("2");
            System.out.println(answer[0] + " " + answer[1]);
        }


    }
}