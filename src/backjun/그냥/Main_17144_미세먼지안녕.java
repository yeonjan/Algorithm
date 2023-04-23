package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_17144_미세먼지안녕 {
	static int R, C, T;
	static ArrayList<int[]> machine = new ArrayList<>();//위 아래
	static int[][] map;
	static int sum = 0;
	static int[][] dust;
	static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		dust = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					machine.add(new int[] {i, j});
				}
			}
		}
		for (int t = 0; t < T; t++) {
			go();
			check();
			work();

		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0)
					sum += map[i][j];
			}
		}

		System.out.println(sum);

	}

	//미세먼지 확산 (상하좌우, 확산된 칸 기존/5의 양,기존칸 줄어듬 공기청정기 제외)
	public static void go() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {
					int val = map[i][j] / 5;
					for (int d = 0; d < 4; d++) {
						int r = i + delta[d][0];
						int c = j + delta[d][1];
						if (r < 0 || c < 0 || r >= R || c >= C)
							continue;
						if (map[r][c] == -1)
							continue;

						dust[r][c] += val;
						map[i][j] -= val;
					}
				}
			}
		}
	}

	//공기 청정기 작동
	public static void work() {
		int dr, dc;
		//위
		//상
		int r = machine.get(0)[0];
		for (int i = r - 1; i > 0; i--) {
			map[i][0] = map[i - 1][0];
		}
		//우
		for (int i = 0; i < C - 1; i++) {
			map[0][i] = map[0][i + 1];
		}
		//하
		for (int i = 0; i < r; i++) {
			map[i][C - 1] = map[i + 1][C - 1];
		}

		for (int i = C - 1; i > 1; i--) {
			map[r][i] = map[r][i - 1];
		}
		map[r][1]=0;
		//아래
		r = machine.get(1)[0];
		//하
		for (int i = r + 1; i < R - 1; i++) {
			map[i][0] = map[i + 1][0];
		}
		//우
		for (int i = 0; i < C - 1; i++) {
			map[R - 1][i] = map[R - 1][i + 1];
		}

		//상
		for (int i = R - 1; i > r; i--) {
			map[i][C - 1] = map[i - 1][C - 1];
		}

		//좌
		for (int i = C - 1; i > 1; i--) {
			map[r][i] = map[r][i - 1];
		}
		map[r][1]=0;

	}

	public static void check() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] += dust[i][j];
				dust[i][j] = 0;

			}

		}
	}
}
