package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_1189_컴백홈 {
	static int R, C, k;
	static int ans;
	static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static String[][] map;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new String[R][C];
		visit = new boolean[R][C];
		visit[R - 1][0] = true;
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().split("");
		}

		dfs(R - 1, 0, 1);
		System.out.println(ans);

	}

	public static void dfs(int r, int c, int dist) {
		if (r == 0 && c == C - 1) {
			if (dist == k) {
				ans++;
			}
		}

		for (int d = 0; d < 4; d++) {
			int dr = r + delta[d][0];
			int dc = c + delta[d][1];
			if (!check(dr, dc) || map[dr][dc].equals("T"))
				continue;
			if (!visit[dr][dc]) {
				visit[dr][dc] = true;
				dfs(dr, dc, dist + 1);
				visit[dr][dc] = false;
			}
		}
	}

	// public static void bfs() {
	// 	ArrayDeque<int[]> queue = new ArrayDeque<>();
	// 	boolean[][] visit = new boolean[r][c];
	// 	visit[r - 1][0] = true;
	// 	queue.offer(new int[] {r - 1, 0});
	//
	// 	int dist = 0;
	//
	// 	while (!queue.isEmpty()) {
	// 		int size = queue.size();
	// 		for (int s = 0; s < size; s++) {
	// 			int[] poll = queue.poll();
	//
	// 			for (int d = 0; d < 4; d++) {
	// 				int dr = poll[0] + delta[d][0];
	// 				int dc = poll[1] + delta[d][1];
	// 				if (!check(dr, dc))
	// 					continue;
	//
	// 				if (!map[dr][dc].equals("T")&&!visit[dr][dc]){
	//
	// 				}
	//
	//
	//
	// 			}
	// 		}
	//
	// 	}
	//
	// }

	public static boolean check(int dr, int dc) {
		return dr >= 0 && dc >= 0 && dr < R && dc < C;
	}
}
