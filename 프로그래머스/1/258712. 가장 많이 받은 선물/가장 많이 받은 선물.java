import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String,Integer> nameMap=new HashMap<>();
        int[][] log=new int[friends.length][friends.length];
        int[] index=new int[friends.length];
        int[] nextMonth=new int[friends.length];
        int num=0;
        for(String friend:friends){
            nameMap.put(friend,num++);
        }
        
//         선물 맵 만들기
         for(String gift:gifts){
             String[] giftLog=gift.split(" ");
             int from=nameMap.get(giftLog[0]);
             int to=nameMap.get(giftLog[1]);
             
             log[from][to]++;
             index[from]++;
             index[to]--;
        }
        
//         다음달에 받을 선물
        for(int a=0;a<friends.length;a++){
            for(int b=0;b<friends.length;b++){
                if(a==b) continue;
                if(log[a][b]==log[b][a]){
                    if(index[a]>index[b]){
                        nextMonth[a]++;
                    }
                    continue;
                }
                
                if(log[a][b]>log[b][a]){
                    nextMonth[a]++;
                }
            }
        }
        
        for(int next:nextMonth){
            answer=Math.max(next,answer);
        }
        
        return answer;
    }
}