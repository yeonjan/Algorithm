package ssafy.과제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10971_외판원순회2_정연진 {
    static int N, ans = Integer.MAX_VALUE;
    static int[][] w;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        N = Integer.parseInt(br.readLine());
        w = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0;i<N;i++){
            visit=new boolean[N];
            visit[i]=true;
            move(0,0,i,i);
        }

        System.out.println(ans);
    }

    public static void move(int cnt, int weight, int from, int start) {
        if (cnt == N-1) {
            if (w[from][start] != 0) ans = Math.min(weight + w[from][start], ans);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i] && w[from][i] != 0) {
                visit[i] = true;
                move(cnt + 1, weight + w[from][i], i, start);
                visit[i] = false;
            }
        }

    }
}
