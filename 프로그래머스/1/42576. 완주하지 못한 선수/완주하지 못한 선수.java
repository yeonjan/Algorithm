import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> map=new HashMap<>();
        for(String p:participant){
            map.put(p,map.getOrDefault(p,0)+1);
        }
        for(String c:completion){
            map.put(c,map.getOrDefault(c,0)-1);
            if(map.get(c)<=0) map.remove(c);
        }
        for(String key:map.keySet()){
            answer=key;
        }
        return answer;
    }
}