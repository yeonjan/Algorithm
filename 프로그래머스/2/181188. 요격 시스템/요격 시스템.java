import java.util.*;
class Solution {

    public int solution(int[][] targets) {
        PriorityQueue<int[]> queue = getMisileQ(targets);
        int answer = countBomb(queue);
        return answer;
    }
    public int countBomb(PriorityQueue<int[]> queue){
        int bomb=0;
        int cnt=0;
        int left=-1;
        int right=-1;
        while(!queue.isEmpty()){
            if(left==-1&&right==-1){
                int[] target=queue.poll();
                left=target[0];
                right=target[1];
                cnt++;
                continue;
            }
            
            //함께 요격 가능?
            if(queue.peek()[0]<right){
                int[] target=queue.poll();
                left=Math.max(left,target[0]);
                right=Math.min(right,target[1]);
                cnt++;
            }else{
                bomb++;
                cnt=0;
                left=-1;
                right=-1;
            }
        }
        if(0<cnt) bomb++;
        return bomb;
        
    }
    public PriorityQueue<int[]> getMisileQ(int[][] targets){
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2)->{
            if(o1[0]==o2[0]){
                return Integer.compare(o1[1],o2[1]);
            }
            return Integer.compare(o1[0],o2[0]);
        });
        for(int[] target:targets){
            queue.offer(target);
        }
        return queue;
        
    }
}

//1. 미사일 s 지점 기준 오름차순 정렬 //s가 같다면 e가 더 짧은게 먼저 오도록
//2. 