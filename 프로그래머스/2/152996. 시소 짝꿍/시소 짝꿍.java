import java.util.*;
class Solution {
    static int MAX=1000;
    public long solution(int[] weights) {
        long answer = 0;
        long[] count=new long[2*MAX+1];
        for(int weight:weights){
            count[weight]++;
        }
        
        for(int i=100;i<=MAX;i++){
            if(count[i]<=0) continue;
            
            //1:1
            answer+=(count[i]*(count[i]-1))/2;
            //2:1
            answer+=count[i]*count[i*2];
            // 3/2:1
            if((i*3)%2==0) answer+=count[i]*count[i*3/2];
            // 4/3:1
            if((i*4)%3==0) answer+=count[i]*count[i*4/3];
        }
        return answer;
    }
}
