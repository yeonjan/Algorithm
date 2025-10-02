import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        PriorityQueue<Integer> max=new PriorityQueue<>((o1,o2)->-Integer.compare(o1,o2));
        PriorityQueue<Integer> min=new PriorityQueue<>((o1,o2)->-Integer.compare(o1,o2));
        
        for(int[] size:sizes){
            max.offer(Math.max(size[0],size[1]));
            min.offer(Math.min(size[0],size[1]));
        }
        
        
        int answer = max.poll()*min.poll();
        return answer;
    }
}