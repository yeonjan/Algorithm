import java.util.*;
class Solution {
    public long solution(int r1, int r2) {
        long answer = countPoints(r1,r2);
        return answer;
    }
    public long countPoints(long r1,long r2){
        long surface=0;
        for(int x=1;x<=r2;x++){
            long y2=(long)Math.sqrt(Math.pow(r2,2)-Math.pow(x,2));
            long y1=(long)Math.ceil(Math.sqrt(Math.pow(r1,2)-Math.pow(x,2)));
            if(y2>=y1) surface+=y2-y1+1;

        }
        
        return surface*4;    
    }
}
//x좌표 기준 y= root(r^2-x^2) 보다 작은 정수의 수

