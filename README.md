# Algorithm

## Prepare for Coding test <br/><br/>

# 목차

- [✨ equals()와 ==의 차이점](#✨-equals와-의-차이점)
- [✨ BFS에서 깊이를 구하는 방법](#✨-bfs에서-깊이를-구하는-방법)
- [✨ 백트래킹과 DFS의 차이](#✨-백트래킹과-dfs의-차이)
- [✨ 2차원 배열의 행과 열에 번호를 부여하는 방법](#✨-2차원-배열의-행과-열에-번호를-부여하는-방법)
- [✨ Collections.sort VS Arrays.sort](#✨-collectionssort-vs-arrayssort)

</br>

## ✨ equals()와 ==의 차이점

- equals()는 대상의 내용 자체를 비교
- ==은 주소값을 비교

![title](img.png)

```java
System.out.println(a.equals(b)); //true
System.out.println(a==b); //true
System.out.println(a==c); //false
System.out.println(a.equals(c)); //true
```

## ✨ BFS에서 깊이를 구하는 방법

---

- while(!queue.isEmpty()) 안에 바로 큐의 사이즈만큼 for문을 돌려서 그 안에 코드 짜기!

```java
public static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
			...
		while (!queue.isEmpty()) {

        dist++; // for문을 썼기 때문에 거리를 명확하게 정할 수 있음

        int size = queue.size();

        // 특정 거리에 해당하는 모든 좌표를 탐색
        for (int i = 0; i < size; i++) {
            int[] current = queue.poll();
						  ...
						queue.offer(new int[]{dr, dc});
				}
		}
}
```

## ✨ 백트래킹과 DFS의 차이

---

- dfs는 끝(최대 깊이)까지 다 돌면 return
- 백트래킹은 중간에 조건 만족 안하면 끝내고 돌아감

## ✨ 2차원 배열의 행과 열에 번호를 부여하는 방법

---

![Untitled](https://user-images.githubusercontent.com/60567697/210377762-8219acde-86e8-4b51-afb7-15134d89a255.png)

```java
for (int i = start; i < 행의크기 * 열의크기; i++) {
            int r = i / 열의크기;
            int c = i % 열의크기;

            if (map[r][c] == 0) {
                selected[cnt] = new int[]{r, c};
                comb(cnt + 1, i + 1);
            }
        }
```

## ✨ Collections.sort VS Arrays.sort

---

[합이 0인 네 정수](https://www.acmicpc.net/problem/7453) 풀이 중 방법은 맞는데 시간초과가 나서 찾아보니 Collections.sort 대신 Arrays.sort를 사용해야 한다고 함.

[글 읽기 - Java 시간초과 나시는분들](https://www.acmicpc.net/board/view/50851)

이유는 primitive type 여부에 따라 정렬에 사용되는 알고리즘이 달라서였다.

primitive type의 경우 dual pivot quicksort가 수행되고, primitive type이 아닌 경우 merge sort가 수행된다.

merge sort에서는 참조지역성으로 인해 캐시 히트율이 떨어져 퀵소트보다 느리다고 한다.

→ 시간 복잡도가 O(NlogN)인 경우 앞에 상수 C 만큼의 시간이 곱해진다. 여기서 참조지역성이 C에 큰 영향을 끼친다.

그러므로 참조지역성이 좋지 않으면 캐시에서 데이터를 꺼내오는 횟수가 줄어들고 정렬은 느려진다.

~~나는 저 마지막 문장이 이해가 안됐다… →~~ 해결

1. 참조지역성이란?

→ 메인 메모리에서 데이터를 가져오면 오래 걸리므로 보통 캐시를 이용,

→ 참조 지역성이란 코드나 데이터가 짧은 시간에 재사용되는 특성을 말한다.

2. 캐시 히트율이란?
