import java.util.*;
class Solution {
    public class Parking{
        Map<String,Integer> timeMap;
        Map<String,Integer> carMap;
        int baseTime;
        int baseFee;
        int unitTime;
        int unitFee;
        
        public Parking(int[] fees){
            this.timeMap=new HashMap<>();
            this.carMap=new HashMap<>();
            this.baseTime=fees[0];
            this.baseFee=fees[1];
            this.unitTime=fees[2];
            this.unitFee=fees[3];
        }
        public void readRecord(String record){
            String[] recordArr=record.split(" "); 
            int time= getIntMinnute(recordArr[0]);
            String num= recordArr[1];
            String act=recordArr[2];
            
            if(act.equals("IN")){
                carMap.put(num,time);
            }else if(act.equals("OUT")){
                int inTime = carMap.get(num);
                putTime(num,time-inTime);
                carMap.remove(num);
                
            }
        }
        public void endDay(){
            List<String> keys=new ArrayList<>(carMap.keySet());
            for(String key:keys){
                readRecord("23:59 "+key+" OUT");
            }
        }
        
        private int getIntMinnute(String time){
            String[] timeStr=time.split(":"); 
            int hour=Integer.valueOf(timeStr[0]);
            int minute=Integer.valueOf(timeStr[1]);
            return hour*60+minute;
        }
        private void putTime(String carNum,int time){
            timeMap.put(carNum,timeMap.getOrDefault(carNum,0)+time);
        }
        
        
        public int[] getFees(){
            PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->Integer.compare(o1[0],o2[0]));
            
            for(Map.Entry<String,Integer> entry:timeMap.entrySet()){
                pq.add(new int[]{Integer.valueOf(entry.getKey()),getFee(entry.getValue())});
                
            }
            int[] fees =new int[pq.size()];
            int i=0;
            while(!pq.isEmpty()){
                int[] fee=pq.poll();
                fees[i++]=fee[1];
            }
            return fees;
        }
        
        private int getFee(int useTime){
            if(useTime<=this.baseTime){
                return this.baseFee;
            }
            
            useTime-=this.baseTime;
            return this.baseFee + (int)Math.ceil((double)useTime/this.unitTime)*this.unitFee;
        }
        
    }
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        Parking parking=new Parking(fees);
        for(String record: records){
            parking.readRecord(record);
        }
        parking.endDay();
        return parking.getFees();
    }
}