import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> watingQ=new ArrayDeque<>();
        for(int truck:truck_weights){
            watingQ.offer(truck);
        }
    
    
        return solve(bridge_length,weight,watingQ);
    }
    public int solve(int length, int weight,Queue<Integer> watingQ){
        Queue<Integer> queue=new ArrayDeque<>();
        for(int i=0;i<length;i++){
            queue.offer(0);
        }
        
        int time=0;
        int sum=0;
        int cnt=0;
        
        while(!watingQ.isEmpty()){
            time++;
            while(!queue.isEmpty()&&length<=queue.size()){
                int outTruck=queue.poll();
                sum-=outTruck;
                if(outTruck!=0){
                    cnt--;
                }
                
            }
            int inTruck=watingQ.peek();
            if(sum+inTruck<=weight&&cnt<=length){
                watingQ.poll();
                queue.offer(inTruck);
                sum+=inTruck;
                cnt++;
            }else{
                queue.offer(0);
            }
        }
        
        return time+=queue.size();
    }
}
//0 0 