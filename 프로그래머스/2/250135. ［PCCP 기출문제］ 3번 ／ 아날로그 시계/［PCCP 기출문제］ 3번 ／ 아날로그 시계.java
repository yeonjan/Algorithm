import java.util.*;
import java.time.*;
class Solution {
    public class Clock{
        boolean isAfternoon;
        int hour;
        int minute;
        int second;
        int alarm;
        double hHand;
        double mHand;
        double sHand;
        
        public Clock(int h,int m,int s){
            if(12<=h){
                this.isAfternoon=true;
                h-=12;
            }else this.isAfternoon=false;
            this.hour=h;
            this.minute=m;
            this.second=s;
            this.alarm=0;
            setHand();
            countAlarm(sHand==mHand,sHand==hHand);
        }
        
        public void passTime(){
            boolean watchMHand=sHand<mHand;
            boolean watchHHand=sHand<hHand;
            
            tickTack();
            countAlarm(watchMHand,watchHHand);
            
            
        }
        private void countAlarm(boolean watchMHand,boolean watchHHand ){
            boolean countAlarm=false;
            double sHand2=sHand;
            if(sHand2==0) sHand2=360;
            
            if(watchMHand&&sHand2>=mHand) alarm++;
            if(watchHHand&&sHand2>=hHand) alarm++;
            if(hour==0&&minute==0&&second==0) alarm--;
        }
        
        private void tickTack(){
            second++;
            if(second==60){
                second=0;
                minute++;
            }
            if(minute==60){
                minute=0;
                hour++;
            }
            if(hour==12){
                hour=0;
            }
            setHand();
        }
        private void setHand(){
            hHand=30*hour + 0.5*minute + (1/120d)*second;
            mHand=6*minute + 0.1*second;
            sHand= 6 * second;
        }
        public void print(){
            System.out.println("h:"+hour+" m:"+minute+" s:"+second);
        }
        
    }
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = -1;
        
        LocalTime startTime=LocalTime.of(h1,m1,s1);
        LocalTime endTime=LocalTime.of(h2,m2,s2);
        Duration duration = Duration.between(startTime, endTime);
        long second=duration.toSeconds();
        
        Clock clock=new Clock(h1,m1,s1);
        System.out.println(second);
        for(long i=0;i<second;i++){
            
            clock.passTime();
        }
        
        return clock.alarm;
    }
    public long getSecond(LocalTime dateTime1,LocalTime dateTime2){
        Duration duration = Duration.between(dateTime1, dateTime2);
        return duration.toSeconds();
    }

}

//시침 각도 -> (360/12)*h + (30/60)*m + (0.5/60)*s
//12:00:00 -> 360도
//11:59:59 -> 359.9...

//분침 각도 -> (360/60)*m + (6/60)*s   => 6은 1분동안 움직이는 각도
//시침 각도 -> 360/60 * s
