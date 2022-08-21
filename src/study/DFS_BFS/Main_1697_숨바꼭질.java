package study.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질 {
    static int N, K, time;
    static boolean[] visit = new boolean[200001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N != K) bfs();
        System.out.println(time);


    }

    public static void bfs() {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(N);
        visit[N] = true;
        End:
        while (!queue.isEmpty()) {
            time++;
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int pos = queue.poll();

                for (int i = 0; i < 3; i++) {
                    int pos2 = pos;
                    switch (i) {
                        case 0:
                            pos2 -= 1;
                            break;
                        case 1:
                            pos2 += 1;
                            break;
                        case 2:
                            pos2 *= 2;
                            break;
                    }
                    if (pos2 < 0 || pos2 > 100000) continue;

                    if (pos2 == K) break End;

                    if (!visit[pos2]) {
                        visit[pos2] = true;
                        queue.offer(pos2);
                    }
                }
            }
        }
    }
}
