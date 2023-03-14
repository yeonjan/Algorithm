package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14499_주사위굴리기 {
	static int n, m, x, y, k;
	static int[] dice = new int[6];
	static int[][] delta = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			int cmd = Integer.parseInt(st.nextToken());
			int dx = x + delta[cmd - 1][0];
			int dy = y + delta[cmd - 1][1];
			if (check(dx, dy))
				continue;

			move(cmd);
			change(dx, dy);

			sb.append(dice[5]).append("\n");
			x = dx;
			y = dy;

		}
		System.out.println(sb);

	}

	public static void move(int k) {
		if (k == 1) {
			int temp = dice[0];
			dice[0] = dice[2];
			dice[2] = dice[5];
			dice[5] = dice[3];
			dice[3] = temp;
		} else if (k == 2) {
			int temp = dice[0];
			dice[0] = dice[3];
			dice[3] = dice[5];
			dice[5] = dice[2];
			dice[2] = temp;
		} else if (k == 3) {
			int temp = dice[0];
			dice[0] = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[4];
			dice[4] = temp;
		} else {
			int temp = dice[0];
			dice[0] = dice[4];
			dice[4] = dice[5];
			dice[5] = dice[1];
			dice[1] = temp;
		}
	}

	public static void change(int x, int y) {
		if (map[x][y] == 0) {
			map[x][y] = dice[0];
		} else {
			dice[0] = map[x][y];
			map[x][y] = 0;
		}

	}

	public static boolean check(int r, int c) {
		return r < 0 || r >= n || c < 0 || c >= m;
	}
}
//1-6
//2-5
//3-4

