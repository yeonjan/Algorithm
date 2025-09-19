import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((o1,o2)->-Integer.compare(o1,o2));
        Queue<Integer> queue=new ArrayDeque<>();
        int[] order=new int[priorities.length];
        for(int i=0;i<priorities.length;i++){
            queue.offer(i);
            pq.offer(priorities[i]);
        }
        
        int cnt=0;
        while(!queue.isEmpty()){
            int cur=queue.poll();
            
            if(priorities[cur]<pq.peek()){
                queue.offer(cur);
            }else{
                pq.poll();
                order[cur]=++cnt;
            }
        }
        
        return order[location];
    }
}
//