import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        char[] input=number.toCharArray();
        ArrayDeque<Integer> deque=new ArrayDeque<>();
        int length=number.length()-k;
        for(char numc:input){
            int num=numc-'0';
            
            if(deque.isEmpty()){
                deque.offer(num);
                continue;
            }
            
            while(!deque.isEmpty()&&deque.peekLast()<num&&k>0){
                deque.pollLast();
                k--;
            }
            deque.offer(num);
        }
        
        while(!deque.isEmpty()&&length-->0){
            sb.append(deque.pollFirst());
        }

        return sb.toString();
    }

}