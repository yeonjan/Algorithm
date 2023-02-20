package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_Z {
	static int n, r, c,total;
	static int[] pos = new int[] {0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		recurs(n);
		System.out.println(total);

	}

	public static void recurs(int d) {
		if (d<=0) return;
		int standNum = (int)(Math.pow(2, d) / 2);
		int cnt = findCnt(pos, standNum);

		total += cnt * Math.pow(standNum, 2);
		recurs(d-1);

	}

	public static int findCnt(int[] pos, int num) {
		if (r < pos[0] + num) {
			if (c < pos[1] + num) {
				return 0;
			} else {
				pos[1] += num;
				return 1;
			}
		} else {
			if (c < pos[1] + num) {
				pos[0] += num;
				return 2;
			} else {
				pos[0] += num;
				pos[1] += num;
				return 3;
			}
		}
	}
}
