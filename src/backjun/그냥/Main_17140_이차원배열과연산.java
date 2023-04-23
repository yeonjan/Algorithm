package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_17140_이차원배열과연산 {
	static int r, c, k;
	static int sizeR = 3;
	static int sizeC = 3;
	static int cnt = 0;
	static int[][] map = new int[101][101];
	static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
		if (o1[1] == o2[1])
			return Integer.compare(o1[0], o2[0]);
		return Integer.compare(o1[1], o2[1]);
	});
	static HashMap<Integer, Integer> hashMap = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (map[r][c] != k) {
			if (cnt > 100) {
				cnt = -1;
				break;
			}
			cnt++;
			if (sizeR >= sizeC) {
				sortR();
			} else {
				sortC();
			}

		}

		System.out.println(cnt);

	}

	public static void sortR() {
		int size = sizeR;
		sizeC = 0;
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j < 101; j++) {
				if (map[i][j] == 0)
					continue;
				if (hashMap.containsKey(map[i][j])) {
					Integer val = hashMap.get(map[i][j]);
					hashMap.put(map[i][j], val + 1);
				} else {
					hashMap.put(map[i][j], 1);
				}
			}
			for (Integer key : hashMap.keySet()) {
				pq.offer(new int[] {key, hashMap.get(key)});
			}
			hashMap.clear();
			int idx = 1;
			sizeC = Math.max(sizeC, pq.size() * 2);
			while (!pq.isEmpty()) {
				if (idx + 1 > 100)
					break;
				int[] poll = pq.poll();
				map[i][idx++] = poll[0];
				map[i][idx++] = poll[1];
			}
			while (idx <= 100) {
				map[i][idx++] = 0;
			}
		}
	}

	public static void sortC() {
		int size = sizeC;
		sizeR = 0;
		for (int j = 1; j <= size; j++) {
			for (int i = 1; i < 101; i++) {
				if (map[i][j] == 0)
					continue;
				if (hashMap.containsKey(map[i][j])) {
					Integer val = hashMap.get(map[i][j]);
					hashMap.put(map[i][j], val + 1);
				} else {
					hashMap.put(map[i][j], 1);
				}
			}
			for (Integer key : hashMap.keySet()) {
				pq.offer(new int[] {key, hashMap.get(key)});
			}
			hashMap.clear();
			int idx = 1;
			sizeR = Math.max(sizeR, pq.size() * 2);
			while (!pq.isEmpty()) {
				if (idx + 1 > 100)
					break;
				int[] poll = pq.poll();
				map[idx++][j] = poll[0];
				map[idx++][j] = poll[1];
			}
			while (idx <= 100) {
				map[idx++][j] = 0;
			}
		}
	}

}
