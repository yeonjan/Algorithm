package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1446_지름길 {
    static int[][] dist;
    static int n, d;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        //i에서 j까지 거리를 저장한 배열
        dist = new int[d + 1][d + 1];
        for (int i = 0; i <= d; i++) {
            for (int j = i + 1; j <= d; j++) {
                dist[i][j] = j - i;
            }
        }

        //지름길 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int shortcut = Integer.parseInt(st.nextToken());
            //지름길 도착지가 고속도로보다 큰 경우 추가x
            if (end > d) continue;
            //지름길이 그냥 간 거리보다 짧다면 배열에 반영
            dist[start][end] = Math.min(dist[start][end], shortcut);
        }

        dijkstra();
        System.out.println(dist[0][d]);


    }

    public static void dijkstra() {
        boolean[] visited = new boolean[d + 1];
        int selectedNode = 0;

        //노드의 횟수만큼 반복(d)
        for (int i = 0; i <= d; i++) {
            int minDist = Integer.MAX_VALUE;
            visited[selectedNode] = true;

            //다음으로 방문할 노드 찾기
            for (int to = 1; to <= d; to++) {
                //이미 방문한 노드는 패스
                if (visited[to]) continue;
                //minNode 기준으로 0에서 부터의 거리 갱신
                if (to > selectedNode) {
                    dist[0][to] = Math.min(dist[0][to], dist[0][selectedNode] + dist[selectedNode][to]);
                }

                //방문하지 않은 노드 중 비용이 가장 적은 노드 찾기
                if (minDist > dist[0][to]) {
                    selectedNode = to;
                    minDist = dist[0][to];
                }
            }
        }
    }
}
