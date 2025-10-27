import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp=new int[triangle.length][triangle.length];
        answer= getAns(dp,triangle);
        return answer;
    }
    public int getAns(int[][] dp,int[][] triangle){
        int max=0;
        dp[0][0]=triangle[0][0];
        for(int d=0;d<triangle.length-1;d++){
            for(int num=0;num<d+1;num++){
                //왼쪽
                dp[d+1][num]=Math.max(dp[d+1][num],dp[d][num]+triangle[d+1][num]);
                //오른쪽
                dp[d+1][num+1]=Math.max(dp[d+1][num+1],dp[d][num]+triangle[d+1][num+1]);
                
            }
        }
        for(int num:dp[triangle.length-1]){
            max=Math.max(max,num);
        }
        return max;
    }
}