package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_2589_보물섬 {
    static int n, m, ans;
    static char[][] map;
    static boolean[][] visited;
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //입력
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        //모든 L에서 bfs
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'L') {
                    visited = new boolean[n][m];
                    visited[i][j] = true;
                    bfs(new Node(i, j));
                }
            }
        }

        System.out.println(ans);
    }

    public static void bfs(Node start) {
        //큐 선언
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(start);

        int dist = 0;//시작 노드에서의 거리
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans = Math.max(ans, dist++); //최대 거리이면 갱신

            for (int s = 0; s < size; s++) {
                Node poll = queue.poll();
                //사방 탐색
                for (int i = 0; i < 4; i++) {
                    int r = poll.r + delta[i][0];
                    int c = poll.c + delta[i][1];

                    if (r < 0 || c < 0 || r >= n || c >= m) continue;
                    if (map[r][c] == 'L' && !visited[r][c]) {
                        visited[r][c] = true;
                        queue.offer(new Node(r, c));
                    }
                }
            }
        }
    }
}