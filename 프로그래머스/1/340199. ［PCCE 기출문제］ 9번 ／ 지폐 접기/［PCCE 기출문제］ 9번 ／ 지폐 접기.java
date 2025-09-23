import java.util.*;
class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int min=Math.min(wallet[0],wallet[1]);
        int max=Math.max(wallet[0],wallet[1]);
        while(checkOk(min,max,bill)){
            if(bill[0]>bill[1]){
                bill[0]/=2;
            }else bill[1]/=2;
            answer++;
        }
        return answer;
    }
    public boolean checkOk(int min, int max, int[] bill){
        return min<Math.min(bill[0],bill[1])||max<Math.max(bill[0],bill[1]);
    }
}