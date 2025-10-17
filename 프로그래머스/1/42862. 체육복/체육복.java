import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students=new int[n+2];
        Arrays.fill(students,1);
        Arrays.sort(reserve);
        for(int r:reserve){
            students[r]++;
        }
        
        for(int l:lost){
            students[l]--;
        }
        for(int r:reserve){
            if(students[r]<2){
                continue;
            }
            
            if(students[r-1]==0){
                //앞번호
                students[r-1]++;
                students[r]--;
            }else if(students[r+1]==0){
               //뒷번호 
                students[r+1]++;
                students[r]--;
            }
            
        }
        for(int i=1;i<=n;i++){
            if(students[i]>0) answer++;
        }
        return answer;
    }
}