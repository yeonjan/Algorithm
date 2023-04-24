package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_9205_맥주마시면서걸어가기 {
	static int t, n;
	static Point startPoint;
	static ArrayList<Point> store = new ArrayList<>();
	static Point endPoint;
	static boolean[] visited;
	static boolean isHappy;

	public static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		int getBear(Point pos) {
			int dist = Math.abs(this.x - pos.x) + Math.abs(this.y - pos.y);
			return (dist-1) / 50 +1;

		}

		public boolean equals(Point pos2) {
			return this.x == pos2.x && this.y == pos2.y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());
			visited = new boolean[n];
			isHappy = false;
			store.clear();

			st = new StringTokenizer(br.readLine());
			startPoint = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				store.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			st = new StringTokenizer(br.readLine());
			endPoint = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			dfs(startPoint, 20);
			System.out.println(isHappy ? "happy" : "sad");

		}

	}

	public static void dfs(Point pos, int bear) {
		if (pos.equals(endPoint)) {
			isHappy = true;
			return;
		}

		int bearToEnd = pos.getBear(endPoint);
		if (bearToEnd <= bear) {
			dfs(endPoint, bear - bearToEnd);
			return;
		}

		for (int i = 0; i < n; i++) {
			Point s = store.get(i);
			int bearToStore = pos.getBear(s);
			if (bearToStore <= bear && !visited[i]) {
				visited[i] = true;
				dfs(s, 20);
			}
		}

	}
}

