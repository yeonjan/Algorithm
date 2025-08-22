import java.util.*;
class Solution {
    static int delta=-1;
    static int[] answer=new int[11];
    public int[] solution(int n, int[] info) {
        dfs(0,n,new int[11],info);
        
        return delta<0?new int[]{-1}:answer;
    }
    public void dfs(int idx,int arrowCnt,int[] ans,int[] info){
        if(10<idx){
            int result=calc(ans,info);
            if(delta<result||(delta==result&&isLow(ans))) {
                delta=result;
                answer=Arrays.copyOf(ans,11);
            }
            return;
        }
        
        //어피치보다 많이 걸기
        if(info[idx]<arrowCnt){
            ans[idx]=info[idx]+1;
            dfs(idx+1,arrowCnt-ans[idx],ans,info);
        }
        
        //포기하기
        ans[idx]=0;
        dfs(idx+1,arrowCnt,ans,info);
        
        if(idx==10){
            ans[idx]=arrowCnt;
            dfs(idx+1,0,ans,info);
        }
    }
    public int calc(int[] ans,int[] info){
        int ryan=0;
        int peach=0;
        
        for(int idx=0;idx<=10;idx++){
            if(info[idx]==0&&ans[idx]==0) continue;
            if(info[idx]<ans[idx]){
                ryan+=10-idx;
            }else{
                peach+=10-idx;
            }
        }
        return peach<ryan?ryan-peach:-1;
        
    }
    public boolean isLow(int[] input){
        for(int idx =10;idx>=0;idx--){
            if(answer[idx]<input[idx]) return true;
            else if(answer[idx]>input[idx]) break;
        }
        return false;
    }
}
//완탐 10!=3622880
//얻는 경우 