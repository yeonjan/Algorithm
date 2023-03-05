package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_16562_친구비 {
	static int n, m, k, total;
	static ArrayList<Friends> list = new ArrayList<>();
	static ArrayList<Friends> list2 = new ArrayList<>();
	static boolean[][] friends;
	static boolean[] visited;

	static class Friends {
		int num;
		int price;

		public Friends(int num, int price) {
			this.num = num;
			this.price = price;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		visited = new boolean[n];
		friends = new boolean[n][n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			Friends friends = new Friends(i, Integer.parseInt(st.nextToken()));
			list.add(friends);
			list2.add(friends);
		}

		Collections.sort(list2, (o1, o2) -> -Integer.compare(o1.price, o2.price));

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			friends[a][b] = true;
			friends[b][a] = true;
		}

		for (Friends friend : list2) {
			if (!visited[friend.num])
				total += search(friend);
		}
		System.out.println(total <= k ? total : "Oh no");

	}

	public static int search(Friends friend) {
		visited[friend.num] = true;
		int price = friend.price;
		for (int i = 0; i < n; i++) {
			if (i == friend.num)
				continue;
			if (!visited[i] && friends[friend.num][i]) {
				price = Math.min(price, search(list.get(i)));
			}
		}

		return price;
	}
}

