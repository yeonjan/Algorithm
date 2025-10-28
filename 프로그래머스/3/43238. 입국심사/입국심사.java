import java.util.*;
class Solution {
    private int n;
    private int[] times;
    
    public long solution(int inputN, int[] inputTimes) {
        long answer = 0;
        n=inputN;
        times=inputTimes;
    
        answer=binarySearch();
        
        return answer;
    }
    public long binarySearch(){
        long left=0;
        long right=n*1000000000L;
        int cnt=0;
        while(left<right){
            long mid=(left+right)/2;
            if(check(mid)) right=mid;
            else left=mid+1;
        }
        return left;
    
    }
    public boolean check(long num){
        long cnt=0;
        for(int time:times){
            cnt+=num/time;
        }
        if(cnt<n) return false;
        else return true;
    }
}