package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_14891_톱니바퀴 {
	static int k;
	static boolean[] visit;

	static List<Gear> gearList = new ArrayList<>();

	static class Gear {
		LinkedList<Integer> info = new LinkedList<>();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 4; i++) {
			String[] input = br.readLine().split("");
			Gear gear = new Gear();
			for (int j = 0; j < 8; j++) {
				gear.info.offer(Integer.parseInt(input[j]));
			}
			gearList.add(gear);

		}

		k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			visit = new boolean[4];
			int num = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());

			go(num, d);
		}
		System.out.println(getScore());

	}

	public static void go(int num, int d) {
		if (!check(num) || visit[num])
			return;
		visit[num] = true;

		LinkedList<Integer> center = gearList.get(num).info;

		//왼쪽
		if (check(num - 1)) {
			LinkedList<Integer> left = gearList.get(num - 1).info;
			if (!left.get(2).equals(center.get(6))) {
				go(num - 1, -d);
			}
		}
		//오른쪽
		if (check(num + 1)) {
			LinkedList<Integer> right = gearList.get(num + 1).info;
			if (!right.get(6).equals(center.get(2))) {
				go(num + 1, -d);
			}
		}

		if (d == 1) {
			Integer last = center.pollLast();
			center.offerFirst(last);
		} else {
			Integer first = center.pollFirst();
			center.offerLast(first);
		}

	}

	public static boolean check(int num) {
		return num >= 0 && num < 4;
	}

	public static int getScore() {
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			sum += gearList.get(i).info.get(0)*Math.pow(2,i);
		}
		return sum;
	}
}
//극이 같으면 회전 X
//극이 다르면 반대호 회전O

//1. 좌우 확인
//2-1. 내 회전 방향 확인
//2-2. 2,6 확인해서 회전