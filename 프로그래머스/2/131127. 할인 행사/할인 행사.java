import java.util.*;
class Solution {
    public class Info{
        Map<String,Integer> map=new HashMap<>();
        int total;
        public Info(String[] want, int[] number){
            this.total=10;
            for(int i=0;i<want.length;i++){
                map.put(want[i],number[i]);
            }
        }
        public void buy(String item){
            if(!map.containsKey(item)) return;
            map.put(item,map.get(item)-1);
            if(0<=map.get(item)){
                total--;
            }
        }
        
        public void extract(String item){
            if(!map.containsKey(item)) return;
            map.put(item,map.get(item)+1);
            if(0<map.get(item)){
                total++;
            }
        }
        
    }
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Info info=new Info(want,number);
        int left=0;
        int right=0;
        int max=discount.length;
        // left~right-1
        while(left<=right&&right<max){
            if(right-left<10){
                info.buy(discount[right]);
                right++;
            }
            
            if(right-left==10){
                if(info.total==0) answer++;
                info.extract(discount[left]);
                left++;
            }
        }
        
        return answer;
        
    }
}