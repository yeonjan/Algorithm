import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->Integer.compare(o1[1],o2[1]));
        Map<Integer,Integer> map=new HashMap<>();
        for(int t:tangerine){
            if(!map.containsKey(t)){
                map.put(t,1);
            }else{
                map.put(t,map.get(t)+1);
            }
        }
        
        for(int key:map.keySet()){
            pq.offer(new int[]{key,map.get(key)});
        }
        
        int outCnt=tangerine.length-k;
        while(0<outCnt&&!pq.isEmpty()){
            int[] tang = pq.poll();
            outCnt-=tang[1];
            if(outCnt<0) answer++;
        }
        answer+=pq.size();
        return answer;
    }
}
//2 2 3 3 5 5 4 1