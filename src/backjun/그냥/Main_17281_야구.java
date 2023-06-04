package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17281_야구 {
    static int n;
    static int ans = 0;
    static int[] order = new int[10];
    static int[][] gettingScore;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        gettingScore = new int[n + 1][10];
        order = new int[10];
        visit = new boolean[10];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                gettingScore[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        order[4] = 1;
        dfs(1);
        System.out.println(ans);


    }

    public static void dfs(int idx) {
        if (idx == 4) {
            dfs(idx + 1);
            return;
        }
        if (idx > 9) {
            calcScore();
            return;
        }

        for (int i = 2; i <= 9; i++) {
            if (!visit[i]) {
                visit[i] = true;
                order[idx] = i;
                dfs(idx + 1);
                visit[i] = false;
            }
        }


    }

    private static void calcScore() {
        int out = 0;
        int inning = 1;
        int[] ground = new int[4]; //1루 2루 3루
        int score = 0;
        while (inning <= n) {
            for (int i = 1; i <= 9; i++) {
                if (inning > n) break;
                int result = gettingScore[inning][order[i]];
                if (result == 0) {
                    out++;
                } else {
                    ground[0] = 1;
                    score += move(ground, result);
                }

                //3아웃 새로운 이닝
                if (out >= 3) {
                    out = 0;
                    inning++;
                    ground = new int[4];
                }

            }
        }
        ans = Math.max(score, ans);

    }

    public static int move(int[] ground, int num) {
        int score = 0;
        for (int i = 3; i >= 0; i--) {
            if (i + num > 3) {
                score += ground[i];
            } else {
                ground[i + num] = ground[i];
            }
            ground[i] = 0;

        }
        return score;
    }
}
// 9명의 타순을 정해야한다. 1번 선수는 4번으로 고정
// 경기는 n 번(이닝) 진행 2~50
// 3아웃 발생할 때 까지 이닝 종료x

// n루에 존재하는 인원 배열에 저장
//
