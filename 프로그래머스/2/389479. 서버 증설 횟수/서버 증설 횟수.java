import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int count=0;
        int server=0;
        //증설서버, 소멸시간
        PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->Integer.compare(o1[1],o2[1]));
        for(int t=0;t<24;t++){
            
            while(!pq.isEmpty()&&pq.peek()[1]<=t){
                server-=pq.poll()[0];
            }
            
//             서버 증설
            int neededServer=players[t]/m;
            if(server<neededServer){
                count+=neededServer-server;
                pq.offer(new int[]{neededServer-server,t+k});
                server=neededServer;
            }
            
        }
        
        return count;
    }
}