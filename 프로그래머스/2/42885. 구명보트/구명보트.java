import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        ArrayDeque<Integer> deque=new ArrayDeque<>();
        Arrays.sort(people);
        for(int i=0;i<people.length;i++){
            deque.offer(people[i]);
        }
        while(!deque.isEmpty()){
            int max=deque.pollLast();
            if(!deque.isEmpty()&&max+deque.peekFirst()<=limit){
                deque.pollFirst();
            }
            answer++;
        }
        return answer;
    }
}
