package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11497_통나무건너뛰기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> queue = new ArrayDeque<>();

		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] l = new int[n];

			for (int i = 0; i < n; i++) {
				l[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(l);

			for (int i = n - 1; i >= 0; i--) {
				if (i % 2 == 0)
					queue.addFirst(l[i]);
				else
					queue.addLast(l[i]);
			}

			int max = 0;
			int first = queue.pollFirst();
			int last = first;
			while (!queue.isEmpty()) {
				Integer first1 = queue.pollFirst();
				max = Math.max(max, Math.abs(last - first1));
				last = first1;
			}
			max = Math.max(max, Math.abs(last - first));

			sb.append(max + "\n");
		}
		System.out.println(sb.toString());

	}
}
