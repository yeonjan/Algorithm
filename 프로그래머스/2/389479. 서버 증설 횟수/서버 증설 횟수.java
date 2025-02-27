import java.util.*;
class Solution {
    static int server=1;
    static int count=0;
    public int solution(int[] players, int m, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->Integer.compare(o1[1],o2[1]));//증설된 서버수,만료시간
        //players 흐르면서 pq에 증설한 서버 넣기
        
        for(int i=0;i<24;i++){
            int player=players[i];
            
            //만료 서버 처리
            while(!pq.isEmpty()&&pq.peek()[1]<=i){
                int[] s=pq.poll();
                server-=s[0];
            }
            
            //증설필요
            int neededServer=player/m+1;
            if(neededServer>server){
                pq.offer(new int[]{neededServer-server,i+k});
                count+=neededServer-server;
                server=neededServer;
            }
            
        }
        
        return count;
    }
}