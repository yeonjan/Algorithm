import java.util.*;
class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int idx=0;
        int cnt=0;
        for(int box=1;box<=order.length;box++){
            boolean isOuted=false;
            if(box==order[idx]){
                cnt++;
                idx++;
                isOuted=true;
            }
            while(!stack.isEmpty()&&stack.peek()==order[idx]){
                stack.pop();
                idx++;
                cnt++;
            }
            
            if(!isOuted) stack.push(box);
        }
        return cnt;
    }
}
// 5
// 1 2