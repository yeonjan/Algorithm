import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int size=sequence.length;
        int left=0;
        int right=0;
        int sum=sequence[0];
        int aLeft=0;
        int aRight=size;
        while(right<size){
            if(sum==k){
                if(right-left<aRight-aLeft){
                    aLeft=left;
                    aRight=right;
                }
            }
            
            if(sum<k){
                if(++right<size) sum+=sequence[right];
                
            }else if(k<=sum){
                sum-=sequence[left++];
            }
        }
        return new int[]{aLeft,aRight};
    }

}