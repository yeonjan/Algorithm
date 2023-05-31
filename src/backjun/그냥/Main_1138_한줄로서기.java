package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1138_한줄로서기 {
	static int n;
	static int[] arr;
	static int[] ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		ans = new int[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			int size = arr[i];
			for (int idx = 1; idx <= n; idx++) {
				if (ans[idx]!=0) continue;
				if (size-- == 0) {
					ans[idx] = i;
				}
			}
		}

		for(int i=1;i<=n;i++){
			sb.append(ans[i]+" ");
		}

		System.out.println(sb);

	}
}
