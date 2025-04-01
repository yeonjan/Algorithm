import java.util.*;
class Solution {
    static int R,C;
    static int cnt=0;
    static int ans=Integer.MAX_VALUE;
    public int solution(int[][] beginning, int[][] target) {
        int answer = 0;
        R=beginning.length;
        C=beginning[0].length;
        
        boolean[] reverseInfo = new boolean[R];
        comb(0,reverseInfo,beginning,target);
        
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public void comb(int idx,boolean[] info,int[][] beginning,int[][] target){
        if(idx>=R){
            ans=Math.min(ans,reverse(beginning,target,info));
            return;
        }
        
        info[idx]=true;
        comb(idx+1,info,beginning,target);
        info[idx]=false;
        comb(idx+1,info,beginning,target);
        
        return;
    }
    public int reverse(int[][] beginning,int[][] target,boolean[] reverseInfo){
        int cnt=0;
        int[][] revMap = new int[R][C];
        
        for(int r=0;r<R;r++){
            if(reverseInfo[r]) cnt++;
            for(int c=0;c<C;c++){
                if(reverseInfo[r]) revMap[r][c] =(beginning[r][c]==0?1:0);
                else revMap[r][c]=beginning[r][c];
                
            }
        }
        // 세로 체크
        for(int c=0;c<C;c++){
            boolean firstState=revMap[0][c]==target[0][c];
            for(int r=1;r<R;r++){
                boolean state=revMap[r][c]==target[r][c];
                //만들 수 없음
                if(firstState!=state) {
                    return Integer.MAX_VALUE;
                }
            }
            if(!firstState){
                cnt++;
            }
        }
        
        
        return cnt;
        
        
    }
    
}
//같으면 짝수번, 다르면 홀수번..

//동일하면 true, 다르면 false
//행 뒤집을 수 있는 경우의 수 2^10 => 1024
//뒤집기 적용 =>10*10
//각 경우의 수 적용했을 때 모두 false 이거나 열 단위로 끊어지면 만들 수 있음 -> 10*10