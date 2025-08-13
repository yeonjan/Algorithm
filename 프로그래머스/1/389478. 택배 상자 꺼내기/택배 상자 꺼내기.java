import java.util.*;
class Solution {
    public class BoxSystem{
        int w;
        int h;
        int top;
        public BoxSystem(int n,int w){
            this.w=w;
            this.h=n/w;
            this.top=n%w;
        }
        public int countBox(int num){
            int cnt=0;
            int boxH=(num-1)/w+1;
            cnt+=h-boxH;
            
            if(top==0) return cnt;
            int boxX=0;
            num=num%(w*2);
            if(num<=w) boxX=num;
            else boxX=w+1-(num-w);
            
            //높이가 짝수 -> 마지막 라인 오른쪽
            if(h%2==0){
                if(boxX<=top) cnt++;
            }else{
                if(w-top<boxX) cnt++;
            }
            return cnt;
        }
        
    }
    public int solution(int n, int w, int num) {
        int answer = 0;
        BoxSystem box=new BoxSystem(n,w);
        return box.countBox(num)+1;
    }
}