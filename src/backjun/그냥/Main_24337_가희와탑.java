package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_24337_가희와탑 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		//1. a b 중 max를 dequeue에 넣기
		ArrayDeque<Integer> dequeue = new ArrayDeque<>();
		dequeue.offer(Math.max(a, b));

		//2. 가희
		if (a - 1 > 0) {
			//a-1 ~ 1 dequeue앞에 넣기
			for (int i = a - 1; i > 0; i--) {
				dequeue.offerFirst(i);
			}
			// n-(a-1)-(b-1)부족한만큼 앞에 1 채우기
			for (int i = 0; i < n - a - (b - 1); i++) {
				dequeue.offerFirst(1);
			}

		}
		//3. 단비
		if (b - 1 > 0) {
			//n-현재 갯수-(b-1)만큼 뒤에 1 채우기
			int size = n - dequeue.size() - (b - 1);
			for (int i = 0; i < size; i++) {
				dequeue.offer(1);
			}

			//b-1 ~ 1 dequeue 뒤에 넣기
			for (int i = b - 1; i > 0; i--) {
				dequeue.offer(i);
			}

		}

		if (a - 1 == 0 && b - 1 == 0) {
			for (int i = 0; i < n - 1; i++) {
				dequeue.offer(1);
			}
		}

		StringBuilder sb = new StringBuilder();
		Object[] answer = dequeue.toArray();
		for (Object ans : answer) {
			sb.append(ans).append(" ");
		}
		System.out.println(dequeue.size() != n ? -1 : sb.toString());

	}
}
