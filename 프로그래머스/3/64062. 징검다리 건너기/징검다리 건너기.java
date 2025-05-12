import java.util.*;

class Solution {

    public int solution(int[] stones, int k) {
        int n=stones.length;
        int left=0;
        int right=200000000;
        
        while(left<=right){
            int mid=(left+right)/2;
            
            if(canGo(mid,stones,k)){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        
           
        return right;
    }
    public boolean canGo(int value,int[] stones,int k){
        int cnt=0;
        for(int stone:stones){
            if(stone<value){
                cnt++;
            }else{
                cnt=0;
            }
            if(cnt==k){
                return false;
            }
        }
        return true;
        
    }
}
