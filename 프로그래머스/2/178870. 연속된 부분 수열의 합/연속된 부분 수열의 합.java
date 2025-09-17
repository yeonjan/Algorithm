import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int size=sequence.length;
        int left=0;
        int right=1;
        int sum=sequence[0];
        int minLength=Integer.MAX_VALUE;
        int[] ans=new int[2];
        int cnt=0;
        while(left<right){
            if(sum==k){
                if(right-left<minLength){
                    minLength=right-left;
                    ans[0]=left;
                    ans[1]=right-1;
                }
            }
            
            if(sum<k){
                if(size==right) break;
                sum+=sequence[right];
                right++;
                
            }else if(k<=sum){
                sum-=sequence[left];
                left++;
            }
        }
        return ans;
    }

}