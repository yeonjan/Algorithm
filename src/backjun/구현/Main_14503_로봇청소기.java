package backjun.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503_로봇청소기 {
	static int total = 0;
	static int n;
	static int m;

	static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int[][] map;

	static class Robot {
		int r;
		int c;
		int d;

		public Robot(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		st = new StringTokenizer(br.readLine());

		Robot robot = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		go(robot);
		System.out.println(total);

	}

	public static void go(Robot robot) {
		//1. 현재칸 청소
		if (map[robot.r][robot.c] == 0) {
			total++;
			map[robot.r][robot.c] = 2;
		}

		//2-1. 사방에 청소O
		if (isClean(robot)) {
			// -> 후진 & 1로
			int d = (robot.d + 2) % 4;
			int dr = robot.r + delta[d][0];
			int dc = robot.c + delta[d][1];
			if (canGo(dr, dc)) {
				go(new Robot(dr, dc, robot.d));
			} 
		} else {//2-2. 사방에 청소x 존재
			// -> 반시계 회전
			int d = (4 + robot.d - 1) % 4;
			int dr = robot.r + delta[d][0];
			int dc = robot.c + delta[d][1];
			// -> if 청소x 전진 & 1로
			if (map[dr][dc] == 0) {
				go(new Robot(dr, dc, d));
			} else {
				go(new Robot(robot.r, robot.c, d));
			}
		}

	}

	public static boolean isClean(Robot robot) {
		for (int d = 0; d < 4; d++) {
			int dr = robot.r + delta[d][0];
			int dc = robot.c + delta[d][1];

			if (map[dr][dc] == 0)
				return false;
		}
		return true;
	}

	public static boolean canGo(int r, int c) {
		return map[r][c] != 1;
	}

}

