package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1976_여행가자 {

    static int[] parent;

    static int find(int a) {
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if (parentA != parentB) {
            int min = Math.min(parentA, parentB);
            parent[parentA] = min;
            parent[parentB] = min;
        }
    }

    //같은 도시에 여러번 방문 가능(여행지 포함) -> 모든 여행지가 연결되어 있는지만 판단
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        //1~n까지 도시들의 부모 노드 정보 저장
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                //1 or 0
                int connect = Integer.parseInt(st.nextToken());

                //도시를 연결하는 길이 없거나 도시가 같을때
                if (connect == 0 || i == j) continue;
                union(i, j);
            }
        }

        //확인하기 전에 parent가 모두 root를 향하도록
        for (int i = 1; i <= n; i++) {
            find(i);
        }

        //출발지의 루트 노드와 나머지 경로의 루트 노드가 같으면 연결되어있다고 판단
        st = new StringTokenizer(br.readLine());
        int r = find(Integer.parseInt(st.nextToken()));
        for (int i = 0; i < m - 1; i++) {
            if (find(Integer.parseInt(st.nextToken())) != r) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}

