import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int R, C;
    static int ans = 0;
    static char[][] map;
    static int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        boolean[] visited = new boolean[26];
        dfs(new int[]{0, 0}, visited, 1);
        System.out.println(ans);

    }

    public static void dfs(int[] pos, boolean[] visited, int cnt) {
        int alphabetIdx = map[pos[0]][pos[1]] - 'A';
        visited[alphabetIdx] = true;
        ans = Math.max(ans, cnt);

        for (int d = 0; d < 4; d++) {
            int dr = pos[0] + delta[d][0];
            int dc = pos[1] + delta[d][1];
            if (dr >= R || dc >= C || dr < 0 || dc < 0) continue;

            int newAlpha = map[dr][dc] - 'A';
            if (!visited[newAlpha]) {
                dfs(new int[]{dr, dc}, visited, cnt + 1);
                visited[newAlpha] = false;
            }
        }

    }

}