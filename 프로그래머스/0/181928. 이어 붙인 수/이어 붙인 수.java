import java.util.*;
class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        StringBuilder evenSb=new StringBuilder();
        StringBuilder oddSb=new StringBuilder();
        for(int num:num_list){
            if(num%2==0){
                evenSb.append(num);
            }else oddSb.append(num);
        }
        answer=Integer.parseInt(evenSb.toString())+Integer.parseInt(oddSb.toString());
        return answer;
    }
}