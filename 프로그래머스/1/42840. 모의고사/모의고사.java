import java.util.*;
class Solution {
    static int[][] pattern={
        {1,2,3,4,5},
        {2,1,2,3,2,4,2,5},
        {3,3,1,1,2,2,4,4,5,5}
    };
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] cnt=new int[3];
        int max=0;
        int ansSize=0;
        for(int i=0;i<answers.length;i++){
            for(int j=0;j<3;j++){
                if(answers[i]==pattern[j][i%pattern[j].length]){
                    cnt[j]++;
                    if(max<cnt[j]){
                        ansSize=1;
                        max=cnt[j];
                    }else if(max==cnt[j]) ansSize++;
                }
                
            }
        }
        
        answer=new int[ansSize];
        int idx=0;
        for(int i=0;i<3;i++){
            if(cnt[i]==max) answer[idx++]=i+1;
        }
        return answer;
    }
}