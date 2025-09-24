import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQ=new PriorityQueue<>();
        PriorityQueue<Integer> maxQ=new PriorityQueue<>((o1,o2)->-Integer.compare(o1,o2));
        Map<Integer,Integer> map=new HashMap<>();
        for(String operation:operations){
            String[] input=operation.split(" ");
            String opt=input[0];
            int num=Integer.valueOf(input[1]);
            
            if(opt.equals("I")){
                minQ.offer(num);
                maxQ.offer(num);
                map.put(num,map.getOrDefault(num,0)+1);
            }else if(num==-1){
                while(!minQ.isEmpty()&&map.get(minQ.peek())==0){
                    minQ.poll();
                }
                
                if(!minQ.isEmpty()){
                    int n=minQ.poll();
                    map.put(n,map.get(n)-1);
                }
            }else if(num==1){
                while(!maxQ.isEmpty()&&map.get(maxQ.peek())==0){
                    maxQ.poll();
                }
                if(!maxQ.isEmpty()){
                    int n=maxQ.poll();
                    map.put(n,map.get(n)-1);
                }
            }
        }
        while(!minQ.isEmpty()&&map.get(minQ.peek())==0){
            minQ.poll();
        }
        while(!maxQ.isEmpty()&&map.get(maxQ.peek())==0){
            maxQ.poll();
        }
        int min=minQ.isEmpty()?0:minQ.peek();
        int max=maxQ.isEmpty()?0:maxQ.peek();
        int[] answer = new int[]{max,min};
        return answer;
    }
}
//minQ -5643 16
//maxQ 16 -5643