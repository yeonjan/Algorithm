import java.util.*;
class Solution {
    static int SIZE=5;
    static int answer=0;
    public int solution(int n, int[][] q, int[] ans) {
        
        comb(n,q,ans,0,1,new int[SIZE]);
        return answer;
    }
    public void comb(int n,int[][] q, int[] ans,int idx,int num,int[] nums){
        if(SIZE<=idx){
            if(findCode(n,q,ans,nums)){
                answer++;
            }
            
            
            return;
        }
        
        for(int i=num;i<=n;i++){
            nums[idx]=i;
            comb(n,q,ans,idx+1,i+1,nums);
        }
    }
    public boolean findCode(int n,int[][] q, int[] ans,int[] nums){
        Map<Integer,Boolean> map=new HashMap<>();
        for(int num:nums){
            map.put(num,Boolean.TRUE);
        }
        
        int m=q.length;
        boolean findCode=true;
        for(int i=0;i<m;i++){
            int[] question=q[i];
            int cnt=0;
            for(int num:question){
                if(map.containsKey(num)) cnt++;
            }
            if(cnt!=ans[i]) findCode=false;
        }
        return findCode;
        
        
        
        
    }
}

//5개의 비밀코드
//m=10
//{1,2}, {1,3} {1,4} {1,5} {2,3} {2,4} {2,5} {3,4} {3,5} {4,5} 
//5C2 => 10개
//


//1. 30C5 -> 142000*10*5