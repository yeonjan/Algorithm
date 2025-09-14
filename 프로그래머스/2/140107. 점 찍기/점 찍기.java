import java.util.*;
class Solution {
    public long solution(int k, int d) {
        long ans = 0;
        int max=d/k;
        for(int a=0;a<=max;a++){
            int maxY=getY(a*k,d);
            ans+=(maxY/k)+1;
        }
        return ans;
    }
    public int getY(int x,int d){
        return (int)Math.sqrt(Math.pow(d,2)-Math.pow(x,2));
    }
}
