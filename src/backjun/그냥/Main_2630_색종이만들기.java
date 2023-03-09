package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2630_색종이만들기 {
	static int n;
	static int totalB = 0;
	static int totalW = 0;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(new int[] {0, 0}, n);

		System.out.println(totalW);
		System.out.println(totalB);

	}

	public static void dfs(int[] startPos, int size) {
		if (isOneColor(startPos, size)) {
			if (getColor(startPos) == 0)
				totalW += 1;
			else
				totalB += 1;

			return;
		}

		int r = startPos[0];
		int c = startPos[1];
		int half = size / 2;
		dfs(startPos, half);
		dfs(new int[] {r, c + half}, half);
		dfs(new int[] {r + half, c}, half);
		dfs(new int[] {r + half, c + half}, half);

	}

	public static boolean isOneColor(int[] startPos, int size) {
		int color = getColor(startPos);
		for (int i = startPos[0]; i < startPos[0] + size; i++) {
			for (int j = startPos[1]; j < startPos[1] + size; j++) {
				if (map[i][j] != color) {
					return false;
				}
			}
		}
		return true;
	}

	public static int getColor(int[] startPos) {
		return map[startPos[0]][startPos[1]];
	}
}
