import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String,Integer> idMap=new HashMap<>();
        Map<String,Set<String>> reported=new HashMap<>();
        int num=0;
        for(String id:id_list){
            reported.put(id,new HashSet<>());
            idMap.put(id,num++);
        }
        
        for(String r:report){
            String[] log= r.split(" ");
            String from =log[0];
            String to=log[1];
            reported.get(to).add(from);
        }
        
        for(Set<String> reporters:reported.values()){
            if(reporters.size()<k) continue;
            for(String reporter:reporters){
                answer[idMap.get(reporter)]++;
            }
        }
        
        
        return answer;
    }
}