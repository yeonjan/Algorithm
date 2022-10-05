package backjun.그냥;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1194_달이차오른다가자 {
    static int n, m, ans = Integer.MAX_VALUE;
    static boolean[][][] visited;
    static char[][] map;
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static class Minsick {
        int r, c, key, dist;

        public Minsick(int r, int c, int key, int dist) {
            this.r = r;
            this.c = c;
            this.key = key;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m][65];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '0') {
                    bfs(i, j);
                }
            }
        }
        if (ans == Integer.MAX_VALUE) ans = -1;
        System.out.println(ans);

    }

    public static void bfs(int i, int j) {
        //A-Z = 65-90, a-z = 97-122
        LinkedList<Minsick> queue = new LinkedList<>();
        queue.offer(new Minsick(i, j, 0, 0));
        visited[i][j][0] = true;


        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                Minsick now = queue.poll();
                if (map[now.r][now.c] == '1') {
                    ans = Math.min(now.dist, ans);
                }
                int dist = now.dist;

                for (int d = 0; d < 4; d++) {
                    int dr = now.r + delta[d][0];
                    int dc = now.c + delta[d][1];
                    int key = now.key;


                    if (dr < 0 || dc < 0 || dr >= n || dc >= m) continue;
                    if (!visited[dr][dc][key]) {
                        visited[dr][dc][key] = true;
                        int next = map[dr][dc];
                        if (next == '#') continue;
                        else if (next == '.' || next == '1' || next == '0')
                            queue.offer(new Minsick(dr, dc, key, dist + 1));
                        else if (map[dr][dc] >= 97) {
                            int num = map[dr][dc] - 'a';
                            //새로운 키면 업데이트
                            if ((key & (1 << num)) == 0) {
                                key = key | (1 << num);
                            }
                            queue.offer(new Minsick(dr, dc, key, dist + 1));
                            visited[dr][dc][key] = true;
                        } else {
                            int num = map[dr][dc] - 'A';
                            //키 가짐
                            if ((key & (1 << num)) != 0) {
                                queue.offer(new Minsick(dr, dc, key, dist + 1));
                                visited[dr][dc][key] = true;
                            }
                        }
                    }
                }
            }
        }
    }
}