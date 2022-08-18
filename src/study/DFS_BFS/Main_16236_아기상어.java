package study.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_16236_아기상어 {
    static int[] deltaR = {-1, 0, 0, 1};
    static int[] deltaC = {0, -1, 1, 0};
    static Point shark;
    static int N, size = 2, time, count = 0;
    static int[][] map;
    static boolean[][] visit;

    static class Point {
        int r;
        int c;
        int dist;

        public Point(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] == 9) {
                    shark = new Point(i, j, 0);
                    map[i][j] = 0;
                    visit[i][j] = true;
                }
            }
        }
        bfs();

        System.out.println(time);
    }

    public static void bfs() {
        PriorityQueue<Point> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.dist == o2.dist) {
                if (o1.r == o2.r) return Integer.compare(o1.c, o2.c);
                return Integer.compare(o1.r, o2.r);
            }
            return Integer.compare(o1.dist, o2.dist);
        });
        queue.offer(shark);
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (map[current.r][current.c] < size && map[current.r][current.c] > 0) {
                time += current.dist;
                visit = new boolean[N][N];
                map[current.r][current.c] = 0;
                current.dist = 0;
                queue.clear();
                if (++count == size) {
                    size++;
                    count = 0;
                }
            }

            for (int i = 0; i < 4; i++) {
                int dr = current.r + deltaR[i];
                int dc = current.c + deltaC[i];
                if (dr < 0 || dr >= N || dc < 0 || dc >= N) continue;
                if (visit[dr][dc]) continue;

                int search = map[dr][dc];
                if (search <= size) {
                    visit[dr][dc] = true;
                    queue.offer(new Point(dr, dc, current.dist + 1));
                }
            }

        }
    }

}