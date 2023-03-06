package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10799_쇠막대기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int size = input.length;
		int total = 0;
		int cnt = 0;

		for (int i = 0; i < size; i++) {
			if (input[i] == '(') {
				if (i + 1 < size && input[i + 1] == ')') {
					total += cnt;
					i++;
				} else {
					cnt++;
				}
			} else {
				cnt--;
				total++;
			}
		}

		System.out.println(total + cnt);

	}
}
