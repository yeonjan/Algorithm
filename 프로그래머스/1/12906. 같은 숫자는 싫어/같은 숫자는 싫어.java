import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for(int a:arr){
            int pre=-1;
            if(!stack.isEmpty()){
                pre=stack.peek();
            }
            if(pre!=a) stack.push(a);
        }
        int[] ans=new int[stack.size()];
        for(int i=ans.length-1;0<=i;i--){
            ans[i]=stack.pop();
        }
        
        return ans;
    }
}