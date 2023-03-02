package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1927_최소힙_힙구현 {

	static class Heap {
		ArrayList<Integer> heap = new ArrayList<>();

		Heap() {
			this.heap.add(0);
		}

		void insert(int num) {
			int lastIdx = this.heap.size();
			heap.add(num);

			while (lastIdx > 1 && heap.get(lastIdx) < heap.get(lastIdx / 2)) {
				int temp = heap.get(lastIdx / 2);
				heap.set(lastIdx, temp);
				heap.set(lastIdx / 2, num);
				lastIdx /= 2;

			}
		}

		int delete() {

			if (this.heap.size() < 2)
				return 0;

			//삭제할 노드
			int min = this.heap.get(1);

			//마지막 노드 root에 삽입
			heap.set(1, heap.get(heap.size() - 1));
			heap.remove(heap.size() - 1);

			int idx = 1;
			while (idx * 2 < heap.size()) {
				int p = heap.get(idx);
				//왼쪽 자식 노드
				int minIdx = idx * 2;
				int minNum = heap.get(minIdx);

				//오른쪽 자식 노드
				if (idx * 2 + 1 < heap.size() && minNum > heap.get(idx * 2 + 1)) {
					minNum = heap.get(idx * 2 + 1);
					minIdx = idx * 2 + 1;
				}

				if (p > minNum) {
					heap.set(idx, minNum);
					heap.set(minIdx, p);
					idx = minIdx;
				} else
					break;
			}

			return min;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Heap heap = new Heap();

		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x != 0) {
				heap.insert(x);
			} else {
				sb.append(heap.delete()).append("\n");
			}
		}

		System.out.println(sb);

	}

}
//배열
// 0 1 2 3 4 5 6
//부모 노드 -> 본인 위치/2