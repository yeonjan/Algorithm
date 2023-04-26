package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_5525_IOIOI {
	static int n;
	static int m;
	static int ans = 0;
	static String s;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		s = br.readLine();

		int cnt = 0;

		int i = 0;
		while (i < m - 2) {
			String substring = s.substring(i, i + 3);
			if (substring.equals("IOI")) {
				cnt++;
				i += 2;
				if (cnt == n) {
					ans++;
					cnt -= 1;
				}
			} else {
				i += 1;
				cnt = 0;
			}
		}

		System.out.println(ans);

	}

}
//1 3
//2 5
//3 7

//num/n +1

