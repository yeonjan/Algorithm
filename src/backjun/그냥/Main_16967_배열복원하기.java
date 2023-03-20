package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16967_배열복원하기 {
	static int H, W, X, Y;
	static int[][] map;
	static int[][] a;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		map = new int[H + X][W + Y];
		a = new int[H][W];

		for (int i = 0; i < H + X; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W + Y; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (i < H && j < W)
					a[i][j] = map[i][j];
			}
		}

		for (int i = X; i < H; i++) {
			for (int j = Y; j < W; j++) {
				a[i][j] -= a[i - X][j - Y];
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				sb.append(a[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());

	}
}
