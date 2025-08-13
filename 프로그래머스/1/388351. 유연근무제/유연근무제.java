import java.util.*;
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int n=schedules.length;
        for(int i=0;i<n;i++){
            if(pass(schedules[i],timelogs[i],startday-1)){
                answer++;
            }
        }
        
        
        return answer;
    }
    public boolean pass(int schedule,int[] logs,int startDay){
        int day=startDay;
        for(int log:logs){
            if(day==5||day==6) {
                day=(day+1)%7;
                continue;
            }
            if(!isOk(schedule,log))return false;
            day=(day+1)%7;
            
        }
        
        return true;
    }
    public boolean isOk(int goal,int eta){
        int goal2=getMinute(goal);
        int eta2=getMinute(eta);
        return eta2<=goal2+10;
        
    }
    public int getMinute(int time){
        int hour=time/100;
        int minute=time%100;
        return hour*60+minute;
    }
}