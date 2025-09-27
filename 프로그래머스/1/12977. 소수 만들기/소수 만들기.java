import java.util.*;
class Solution {
    static int ans=0;
    public int solution(int[] nums) {
        comb(new boolean[nums.length],nums,0,0,0);

        return ans;
    }
    public void comb(boolean[] visit,int[] nums,int sum,int idx,int cnt){
        if(cnt==3){
            if(isPrime(sum)){
                ans++;
            } 
            return;
        }
        for(int i=idx;i<nums.length;i++){
            if(visit[i]) continue;
            visit[i]=true;
            comb(visit,nums,sum+nums[i],i+1,cnt+1);
            visit[i]=false;
            
        }
    }
    public boolean isPrime(int num){
        for(int i=2;i*i<=num;i++){
            if(num%i==0) return false;
        }
        return true;
    }
}