import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        int n=sequence.length;
        long[][] dp=new long[n][2];
        dp[0][0]=sequence[0];
        dp[0][1]=-sequence[0];
        long max=Math.max(dp[0][0],dp[0][1]);
                                
        for(int i=1;i<n;i++){
            dp[i][0]=Math.max(sequence[i],dp[i-1][1]+sequence[i]);
            dp[i][1]=Math.max(-sequence[i],dp[i-1][0]-sequence[i]);
            max=Math.max(dp[i][0],max);
            max=Math.max(dp[i][1],max);
        }
        return max;
        
    
    }
}