package study.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2606_바이러스 {
    static int cnt;
    static ArrayList<Integer>[] computer;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());
        computer = new ArrayList[num + 1];
        visit = new boolean[num + 1];
        for (int i = 0; i <= num; i++) {
            computer[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < num2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            computer[u].add(v);
            computer[v].add(u);
        }

        if (!computer[1].isEmpty()) {
            trace(1);
        }

        System.out.println(cnt != 0 ? cnt - 1 : 0);


    }

    public static void trace(int u) {
        if (computer[u].isEmpty()) {
            return;
        }

        cnt++;
        for (int i : computer[u]) {
            if (i != 1 && !visit[i]) {
                visit[i] = true;
                trace(i);
            }
        }


    }
}
