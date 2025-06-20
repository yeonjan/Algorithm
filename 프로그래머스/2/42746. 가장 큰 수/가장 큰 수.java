import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        ArrayList<String> arr = new ArrayList<>();
        
        for(int num:numbers){
            arr.add(String.valueOf(num));
        }
        Collections.sort(arr,(o1,o2)->{
            return -(o1+o2).compareTo(o2+o1);
        });
        
        StringBuilder sb=new StringBuilder();
        
        for(String s:arr){
            if(sb.toString().equals("0")&&s.equals("0")) continue;
            sb.append(s);
        }
        
        
        return sb.toString();
    }
}