package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_5014_스타트링크 {
	static int F, S, G, U, D;
	static int[] upDown;
	static int[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = -Integer.parseInt(st.nextToken());

		upDown = new int[] {U, D};
		visit = new int[F + 1];
		Arrays.fill(visit, Integer.MAX_VALUE);

		bfs();

		System.out.println(visit[G] != Integer.MAX_VALUE ? visit[G] : "use the stairs");
	}

	public static void bfs() {
		LinkedList<Integer> queue = new LinkedList<>();
		visit[S] = 0;
		queue.offer(S);

		while (!queue.isEmpty()) {
			Integer poll = queue.poll();

			for (int n : upDown) {
				int next = poll + n;
				if (next > F || next <= 0)
					continue;

				if (visit[next] > visit[poll] + 1) {
					visit[next] = visit[poll] + 1;
					queue.offer(next);
				}

			}

		}

	}
}
