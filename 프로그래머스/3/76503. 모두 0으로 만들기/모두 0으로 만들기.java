import java.util.*;

class Solution {

    boolean[] visit;
    int aLen;
    Map<Integer, List<Integer>> map = new HashMap<>();
    long[] a;

    class Node {

        public int v;
        public int parentV;
        public long cnt;

        public Node(int v, int parentV, long cnt) {
            this.v = v;
            this.parentV = parentV;
            this.cnt =cnt;
        }
    }

    Integer getLeafNode(Integer currNode) {

        if(!map.containsKey(currNode)) {
            return currNode;
        }

        visit[currNode] = true;

        for(Integer nextNode : map.get(currNode)) {
            if(visit[nextNode]) {
                continue;
            }

            Integer leafNode = getLeafNode(nextNode);
            visit[currNode] = false;
            return leafNode;
        }

        visit[currNode] = false;

        return currNode;
    }

    void init(int[][] edges, int[] a) {
        for(int[] edge : edges) {
            for(int v : edge) {
                if(!map.containsKey(v)) {
                    map.put(v, new ArrayList<>());
                }
            }

            int u = edge[0];
            int v = edge[1];

            map.get(u).add(v);
            map.get(v).add(u);
        }

        this.a = new long[aLen];
        for(int i=0; i<a.length; i++) {
            this.a[i] = a[i];
        }
    }

    // 스택 오버 플로우 안나는 dfs 
    long dfs(int startV) {

        Deque<Node> deque = new LinkedList<>();

        Node startNode = new Node(startV, startV, 0);
        deque.offerLast(startNode);

        while(!deque.isEmpty()) {

            Node currNode = deque.pollLast();

            if(!visit[currNode.v]) {

                visit[currNode.v] = true;

                deque.offer(currNode);

                List<Integer> nextVLis = map.get(currNode.v);

                for(int nextV : nextVLis) {
                    if(visit[nextV]) {
                        continue;
                    }
                    Node nextNode = new Node(nextV, currNode.v, 0);
                    deque.offerLast(nextNode);
                }
            } else {
                visit[currNode.v] = false;

                if(currNode.v == startV) {
                    if(a[currNode.v] != 0) {
                        return -1;
                    } else {
                        return currNode.cnt;
                    }
                }

                if(a[currNode.v] == 0) {
                    if(!deque.isEmpty()) {
                        deque.peekLast().cnt += currNode.cnt;
                    }
                    continue;
                }

                long weight = a[currNode.v];
                a[currNode.v] = 0;
                a[currNode.parentV] += weight;
                currNode.cnt += Math.abs(weight);

                deque.peekLast().cnt += currNode.cnt;                
            }
        }

        return -1;
    }

    public long solution(int[] a, int[][] edges) {
        long answer = -1;

        this.aLen = a.length;
        this.visit = new boolean[aLen];
        init(edges, a);

        int startNode = getLeafNode(edges[0][0]);
        answer = dfs(startNode);

        return answer;
    }
}