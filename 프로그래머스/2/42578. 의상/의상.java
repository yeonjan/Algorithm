import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        Map<String,Integer> map=new HashMap<>();
        for(String[] c:clothes){
            map.put(c[1],map.getOrDefault(c[1],1)+1);
        }
        
        int ans=1;
        for(String key:map.keySet()){
            ans*=map.get(key);
        }
        
        return ans-1;
    }
}