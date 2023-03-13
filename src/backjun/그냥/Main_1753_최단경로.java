package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753_최단경로 {
	static int start;
	static int v;
	static int e;
	static ArrayList<int[]>[] adj;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());

		dist = new int[v + 1];
		adj = new ArrayList[v + 1];
		for (int i = 0; i <= v; i++) {
			adj[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[a].add(new int[] {b, c});
		}
		dijkstra();

		for (int i = 1; i <= v; i++) {
			sb.append(dist[i] != Integer.MAX_VALUE ? dist[i] : "INF").append("\n");
		}
		System.out.println(sb);

	}

	public static void dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		pq.offer(new int[] {start, 0});
		dist[start] = 0;

		while (!pq.isEmpty()) {
			int[] node = pq.poll();
			int weight = node[1];

			for (int[] next : adj[node[0]]) {
				int nextW = weight + next[1];
				if (dist[next[0]] > nextW) {
					dist[next[0]] = nextW;
					pq.offer(new int[] {next[0], nextW});
				}

			}

		}

	}
}

//한 점에서 다른 곳까지의 최소거리 -> 다익스트라
//거리 배열 업데이트 ->pq
//시작점은 0 나머지는 최소값
