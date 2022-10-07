package ssafy.수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_17472_다리만들기2 {
    static int n, m, landSize;
    static int[][] map, minDist, delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //섬 번호 붙이기
        int islandNum = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    map[i][j] = islandNum;
                    setIsland(islandNum, i, j);
                    islandNum++;
                }
            }
        }
        landSize = islandNum - 2;
        minDist = new int[landSize][landSize];
        for (int i = 0; i < landSize; i++) {
            Arrays.fill(minDist[i], Integer.MAX_VALUE);
        }

        //최소 다리 길이 계산
        islandNum = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == islandNum) {
                    minDist[islandNum - 2][islandNum - 2] = 0;
                    setBridge(islandNum, i, j);
                    islandNum++;
                }
            }
        }
        int ans = prime();
        System.out.println(ans);

    }

    public static int prime() {
        int result = 0;
        int cnt = 0;

        //int arr[0]= 섬 번호 arr[1]= 비용
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        pq.offer(new int[]{0, 0});
        boolean[] visited = new boolean[landSize];

        while (cnt < landSize && !pq.isEmpty()) {

            int[] minV = pq.poll();

            if (!visited[minV[0]]) {
                cnt++;
                visited[minV[0]] = true;
                result += minV[1];

                for (int to = 0; to < landSize; to++) {
                    if (to == minV[0]) continue;
                    int dist = minDist[minV[0]][to];
                    if (!visited[to] && dist != Integer.MAX_VALUE) {
                        pq.offer(new int[]{to, dist});
                    }
                }
            }
        }
        if (cnt != landSize) result = -1;
        return result;
    }

    // 섬을 연결하는 다리의 최소값
    public static void setBridge(int islandNum, int i, int j) {
        boolean[][] visited = new boolean[n][m];
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int d = 0; d < 4; d++) {
                int dr = poll[0] + delta[d][0];
                int dc = poll[1] + delta[d][1];

                if (!check(dr, dc)) continue;

                if (!visited[dr][dc]) {
                    if (map[dr][dc] == 0) {
                        int dist = 0;
                        while (map[dr][dc] == 0) {
                            dist++;
                            dr += delta[d][0];
                            dc += delta[d][1];
                            if (!check(dr, dc)) {
                                dist = 0;
                                break;
                            }
                        }

                        if (dist >= 2) {
                            int next = map[dr][dc];
                            int min = Math.min(minDist[islandNum - 2][next - 2], dist);
                            minDist[islandNum - 2][next - 2] = min;
                            minDist[next - 2][islandNum - 2] = min;
                        }
                    } else {
                        visited[dr][dc] = true;
                        queue.offer(new int[]{dr, dc});
                    }
                }
            }

        }

    }

    public static void setIsland(int islandNum, int i, int j) {
        boolean[][] visited = new boolean[n][m];
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int d = 0; d < 4; d++) {
                int dr = poll[0] + delta[d][0];
                int dc = poll[1] + delta[d][1];

                if (dr < 0 || dc < 0 || dr >= n || dc >= m) continue;

                if (!visited[dr][dc] && map[dr][dc] == 1) {
                    map[dr][dc] = islandNum;
                    visited[dr][dc] = true;
                    queue.offer(new int[]{dr, dc});
                }
            }

        }

    }

    public static boolean check(int dr, int dc) {
        return dr >= 0 && dc >= 0 && dr < n && dc < m;
    }

}
