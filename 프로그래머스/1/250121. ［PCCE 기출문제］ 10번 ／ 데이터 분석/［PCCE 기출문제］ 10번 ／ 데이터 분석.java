import java.util.*;
class Solution {
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list=new ArrayList<>();
        int sortNum=getNum(sort_by);
        int extNum=getNum(ext);
        
        PriorityQueue<int[]> pq =new PriorityQueue<>((o1,o2)->Integer.compare(o1[sortNum],o2[sortNum]));
        
        for(int[] d:data){
            pq.offer(d);
        } 
        
        while(!pq.isEmpty()){
            int[] data2=pq.poll();
            if(data2[extNum]<val_ext)list.add(data2);
        }
        
        int[][] answer=new int[list.size()][4];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        
        return answer;
    }
    public int getNum(String field){
        if(field.equals("code")){
            return 0;
        }else if(field.equals("date")){
            return 1;
        }else if(field.equals("maximum")){
            return 2;
        }else {
            return 3;
        }
    }
}