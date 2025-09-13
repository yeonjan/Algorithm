import java.util.*;
class Solution {
    static int[][] fatigueMap={{1,1,1},{5,1,1},{25,5,1}};
    static int min=Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        int size=(minerals.length-1)/5+1;
        int[] mineralsInt=new int[minerals.length];
        for(int i=0;i<minerals.length;i++){
            if(minerals[i].equals("diamond")) mineralsInt[i]=0;
            else if(minerals[i].equals("iron")) mineralsInt[i]=1;
            else mineralsInt[i]=2;
        }
        int[] pickUp=new int[size];
        Arrays.fill(pickUp,-1);
        dfs(0,size,picks,pickUp,mineralsInt);
        
        return min;
    }
    public void dfs(int idx,int size,int[] picks,int[] pickUp,int[] minerals){
        if(size<=idx){
            min=Math.min(min,getFatigue(pickUp,minerals));
         
            return;
        }
        boolean findPick=false;
        for(int i=0;i<3;i++){
            if(0<picks[i]){
                picks[i]--;
                pickUp[idx]=i;
                findPick=true;
                dfs(idx+1,size,picks,pickUp,minerals);
                picks[i]++;
            }
        }
        if(!findPick) dfs(size,size,picks,pickUp,minerals);
        
        
    }
    public int getFatigue(int[] pickUp,int[] minerals){
        int idx=0;
        int cnt=0;
        int sum=0;
        for(int mineral:minerals){
            if(5<=cnt){
                cnt=0;
                idx++;
            }
            if(pickUp[idx]==-1) return sum;
            sum+=fatigueMap[pickUp[idx]][mineral];
            cnt++;
            
        }
        return sum;
        
    }

}
//광물 50개 => 곡괭이 10개