package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1927_최소힙_우선순위큐 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());

			if (x == 0) {
				Integer min = pq.poll();
				sb.append(min != null ? min : 0).append("\n");
				continue;
			}
			pq.offer(x);
		}
		System.out.println(sb);
	}
}
