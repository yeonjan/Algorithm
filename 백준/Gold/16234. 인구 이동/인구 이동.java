import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, L, R;
        int[][] map;

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        boolean isChanged;
        while (true) {
            isChanged = false;
            boolean[][] visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        List<int[]> teams = new ArrayList<>();
                        // 1. 연합 찾기 50*50
                        int absPopulation = findTeam(teams, visited, map, new int[]{i, j}, N, L, R);
                        // 2. 인구수 변경 50*50
                        if ( 1< teams.size()) {
                            isChanged = true;
                            setPopulation(teams, map, absPopulation);
                        }
                    }
                }
            }
            if (!isChanged) {
                break;
            }
            day++;

        }
        System.out.println(day);


    }


    public static int findTeam(List<int[]> teams, boolean[][] visited, int[][] map, int[] start, int N, int L, int R) {
        int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        int sum = 0;
        int cnt = 0;

        while (!queue.isEmpty()) {
            int[] country = queue.poll();
            teams.add(country);
            int posR = country[0];
            int posC = country[1];
            sum += map[posR][posC];
            cnt++;

            for (int d = 0; d < 4; d++) {
                int dr = posR + delta[d][0];
                int dc = posC + delta[d][1];
                if (dr < 0 || dc < 0 || N <= dr || N <= dc) {
                    continue;
                }

                if (visited[dr][dc]) continue;

                int diff = Math.abs(map[posR][posC] - map[dr][dc]);
                //연합 가능
                if (L <= diff && diff <= R) {
                    visited[dr][dc] = true;
                    queue.add(new int[]{dr, dc});
                }
            }


        }
        return sum / cnt;
    }

    public static void setPopulation(List<int[]> teams, int[][] map, int population) {
        for (int[] country : teams) {
            map[country[0]][country[1]] = population;
        }
    }

}

