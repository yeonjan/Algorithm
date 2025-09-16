import java.util.*;

public class Solution {
    public List<Integer> solution(int []arr) {
        List<Integer> list=new ArrayList<>();
        for(int a:arr){
            if(list.size()!=0&&list.get(list.size()-1)==a){
                continue;
            }
            list.add(a);
        }
        
        return list;
    }
}