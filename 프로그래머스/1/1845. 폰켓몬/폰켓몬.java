import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n =nums.length/2;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,0);
        }
        
        int size = map.size();
        return size>n?n:size;
    }
}