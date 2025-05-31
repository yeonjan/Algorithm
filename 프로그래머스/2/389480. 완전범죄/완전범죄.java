import java.util.*;
//배낭 문제 활용
class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = -1;
        int size=info.length;
        System.out.println(size);
        int[][] dp=new int[size+1][n];//값은 b의 흔적
        for(int a=0;a<n;a++){
            for(int i=1;i<=size;i++){
                
                int steelA=Integer.MAX_VALUE;
                int steelB=Integer.MAX_VALUE;
                //A가 훔치는 경우
                if(0<=a-info[i-1][0]){
                    steelA=dp[i-1][a-info[i-1][0]];
                }
                //B가 훔치는 경우
                steelB=dp[i-1][a]+info[i-1][1];
                
                dp[i][a]=Math.min(steelA,steelB);
                
            }
            if(dp[size][a]<m){
                answer=a;
                break;
            }
        }
        return answer;
    }
   
}
//둘다 안 걸림 & A도둑 흔적 합 최소
//물건 i개
//a도둑이 남긴 흔적의 개수 n까지


//A가 뽑는 경우 dp[i-1][n-info[i][0]] if(n-info[i][0]<0) A가 못듬;; 바로 B가 뽑는 경우
//B가 뽑는 경우 dp[i-1][n]+info[i][1];
