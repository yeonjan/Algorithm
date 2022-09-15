package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_15591_mootube_silver {
    static int n, q, k, v, ans;
    static List<int[]>[] adjlist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        adjlist = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjlist[i] = new ArrayList<>();
        }

        //유사도 입력받음
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int usado = Integer.parseInt(st.nextToken());
            adjlist[p].add(new int[]{q, usado});
            adjlist[q].add(new int[]{p, usado});
        }


        for (int i = 0; i < q; i++) {
            //ans, visited 초기화
            ans = 0;
            Arrays.fill(visited, false);

            //k,v 입력
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            dfs(v, Integer.MAX_VALUE);

            sb.append(ans + "\n");

        }

        System.out.println(sb);

    }

    public static void dfs(int video, int usado) {
        visited[video] = true;

        //현재 동영상에서 갈 수 있는 동영상
        for (int[] v : adjlist[video]) {

            if (!visited[v[0]]) {
                //유사도가 k보다 작으면 더이상 탐색하지 x
                int usadoV = Math.min(usado, v[1]);
                if (usadoV >= k) {
                    ans++;
                    dfs(v[0], usadoV);
                }
            }
        }
    }
}
//입력 값 인접 리스트 만들기
// V값을 시작점으로으로 DFS하며 min값이 k보다 크면 +1
