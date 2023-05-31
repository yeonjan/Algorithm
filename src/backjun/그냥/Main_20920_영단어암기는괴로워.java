package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_20920_영단어암기는괴로워 {
	static int n;
	static int m;

	static class Word {
		String word;
		int count;
		int length;

		Word(String w, int c, int l) {
			this.word = w;
			this.count = c;
			this.length = l;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		PriorityQueue<Word> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1.count == o2.count) {
				if (o1.length == o2.length) {
					return o1.word.compareTo(o2.word);
				}
				return -Integer.compare(o1.length, o2.length);
			}
			return -Integer.compare(o1.count, o2.count);
		});

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			if (input.length() < m)
				continue;

			if (!map.containsKey(input)) {
				map.put(input, 0);
			} else {
				map.put(input, map.get(input) + 1);
			}
		}

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String word = entry.getKey();
			pq.add(new Word(entry.getKey(), entry.getValue(), word.length()));
		}
		while (!pq.isEmpty()) {
			sb.append(pq.poll().word).append("\n");
		}
		System.out.println(sb);

	}
}
