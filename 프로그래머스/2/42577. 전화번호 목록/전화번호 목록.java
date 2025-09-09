import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Map<String,Boolean> map=new HashMap<>();
        StringBuilder sb=new StringBuilder();
        for(String phone:phone_book){
            map.put(phone,true);
        }
        for(String phone:phone_book){
            char[] arr=phone.toCharArray();
            sb.setLength(0);
            for(int i=0;i<phone.length()-1;i++){
                sb.append(arr[i]);
                if(map.containsKey(sb.toString())){
                    return false;
                }
                    
            }

        }
        return true;
    }
   
}