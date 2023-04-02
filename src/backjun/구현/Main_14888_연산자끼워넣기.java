package backjun.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888_연산자끼워넣기 {
	static int n;
	static int[] num;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int[] opt = new int[4];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		num = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			opt[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, num[0]);

		System.out.println(max);
		System.out.println(min);

	}

	public static void dfs(int cnt, int value) {
		if (cnt == n-1) {
			max = Math.max(max, value);
			min = Math.min(min, value);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (opt[i] > 0) {
				opt[i]--;
				dfs(cnt + 1, calc(value, num[cnt + 1], i));
				opt[i]++;
			}
		}

	}

	public static int calc(int a, int b, int o) {
		if (o == 0) {
			return a + b;
		} else if (o == 1) {
			return a - b;
		} else if (o == 2) {
			return a * b;
		} else {
			return a / b;
		}
	}
}
