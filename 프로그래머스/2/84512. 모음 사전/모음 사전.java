import java.util.*;
class Solution {
    static int cnt=-1;
    static String[] vowels={"A","E","I","O","U"};
    public int solution(String word) {
        solve(new StringBuilder(),word,0);
        return cnt;
    }
    public boolean solve(StringBuilder sb,String word,int idx){
        cnt++;
        if(word.equals(sb.toString())){
            return true;
        }
        if(idx==5){
            return false;
        }
        
        for(String vowel:vowels){
            sb.append(vowel);
            if(solve(sb,word,idx+1)) return true;
            sb.deleteCharAt(idx);
        }
        return false;
    }
}