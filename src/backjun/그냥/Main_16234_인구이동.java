package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_16234_인구이동 {
	static int n, L, R;
	static int day = 0;
	static boolean isEnd = false;
	static int[][] map;
	static int[][] changeMap;
	static boolean[][] visit;
	static int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static ArrayList<Integer> numList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (!isEnd) {
			int num = 0;
			isEnd = true;
			changeMap = new int[n][n];
			visit = new boolean[n][n];
			numList.clear();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visit[i][j]) {
						bfs(new int[] {i, j}, num++);
					}
				}
			}
			if (!isEnd) {
				change();
				day++;
			}

		}

		System.out.println(day);

	}

	public static void bfs(int[] pos, int num) {
		int cnt = 1;
		int sum = map[pos[0]][pos[1]];
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.offer(pos);

		changeMap[pos[0]][pos[1]] = num;
		visit[pos[0]][pos[1]] = true;

		while (!queue.isEmpty()) {
			int[] poll = queue.poll();

			for (int d = 0; d < 4; d++) {
				int r = poll[0] + delta[d][0];
				int c = poll[1] + delta[d][1];
				if (!check(r, c))
					continue;

				int val = Math.abs(map[r][c] - map[poll[0]][poll[1]]);
				if (!visit[r][c] && val >= L && val <= R) {
					visit[r][c] = true;
					queue.offer(new int[] {r, c});
					isEnd = false;
					cnt++;
					sum += map[r][c];
					changeMap[r][c] = num;
				}

			}
		}
		numList.add(cnt == 0 ? 0 : sum / cnt);
	}

	public static void change() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int num = numList.get(changeMap[i][j]);
				if (num != 0) {
					map[i][j] = num;
					map[i][j] = num;
				}
			}
		}
	}

	public static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < n && c < n;
	}
}

//bfs로 체크하면서 연합국 구하기
// 갯수, 위치 배열에 기록, 총 인구수
// 평균값으로 넣기