package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1629_곱셈 {
	static long a, c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		a = Integer.parseInt(input[0]);
		long b = Integer.parseInt(input[1]);
		c = Integer.parseInt(input[2]);

		System.out.println(recurs(b));

	}

	public static long recurs(long b) {
		if (b == 1) {
			return a % c;
		}

		long val = recurs(b / 2);
		if (b % 2 == 0) {
			return val * val % c;
		} else {
			return val * val % c *  a % c;
		}

	}
}
