package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_1764_듣보잡 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		HashMap<String, Integer> map = new HashMap<>();
		ArrayList<String> list = new ArrayList<>();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			map.put(br.readLine(), 1);
		}
		for (int i = 0; i < m; i++) {
			String person = br.readLine();
			if (map.containsKey(person)) {
				cnt++;
				list.add(person);
			}
		}

		Collections.sort(list);
		sb.append(cnt+"\n");
		for (String a:list) {
			sb.append(a + "\n");
		}
		System.out.println(sb);
	}
}
