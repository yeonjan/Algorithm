import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0;
        long left=0;
        long right=(long)times[times.length-1]*n;
        
        while(left+1<right){
            long mid= (left+right)/2L;
            long count=0;
            
            for(int t:times){
                count+=mid/t;
            }
            
            if(n<=count){
                right=mid;
            }else if (n>count){
                left=mid;
            }
        }
        
        return right;
    }

}