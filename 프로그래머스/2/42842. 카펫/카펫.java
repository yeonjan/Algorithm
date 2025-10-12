import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int total=brown+yellow;
        for(int h=3;h*h<=total;h++){
            if(total%h!=0) continue;
            int w=total/h;
            if((w*2)+(h*2-4)==brown) {
                answer=new int[]{w,h};
                break;
            }
        }
        return answer;
    }

}
