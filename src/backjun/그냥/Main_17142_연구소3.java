package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_17142_연구소3 {
	static int n, m;
	static int ans = Integer.MAX_VALUE;
	static int size;
	static int[][] map;
	static int[][] delta = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static boolean[] selected;
	static boolean[][] visitMap;

	static ArrayList<int[]> virusList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		visitMap = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virusList.add(new int[] {i, j});
				}
				if (map[i][j] == 1)
					visitMap[i][j] = true;
			}
		}

		size = virusList.size();
		selected = new boolean[size];
		getVirusPos(0, 0);
		System.out.println(ans != Integer.MAX_VALUE ? ans : -1);

	}

	public static void getVirusPos(int cnt, int idx) {
		if (cnt == m) {
			//바이러스 시간 계싼 코드
			bfs();
			return;
		}

		for (int i = idx; i < size; i++) {
			selected[i] = true;
			getVirusPos(cnt + 1, i + 1);
			selected[i] = false;
		}

	}

	public static void bfs() {
		LinkedList<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			visited[i] = visitMap[i].clone();
		}

		for (int i = 0; i < size; i++) {
			if (selected[i]) {
				int[] virus = virusList.get(i);
				visited[virus[0]][virus[1]] = true;
				queue.offer(virus);
			}
		}

		int time = 0;
		while (!queue.isEmpty()&&!isEnd(visited)) {
			time++;
			int cnt = queue.size();
			for (int i = 0; i < cnt; i++) {
				int[] poll = queue.poll();

				for (int d = 0; d < 4; d++) {
					int dr = poll[0] + delta[d][0];
					int dc = poll[1] + delta[d][1];

					if (dr < 0 || dc < 0 || dr >= n || dc >= n)
						continue;

					if (!visited[dr][dc]) {
						visited[dr][dc] = true;
						queue.offer(new int[] {dr, dc});
					}

				}
			}
		}

		if (isEnd(visited)) {
			ans = Math.min(ans, time);
		}

	}

	public static boolean isEnd(boolean[][] visit) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit[i][j]&&map[i][j]!=2)
					return false;
			}
		}
		return true;
	}
}
