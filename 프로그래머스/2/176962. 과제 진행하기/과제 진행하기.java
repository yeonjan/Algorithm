import java.util.*;
class Solution {
    class Work{
        String name;
        int start;
        int playTime;
        public Work(String[] plan){
            String[] time=plan[1].split(":");
            this.name=plan[0];
            this.start=Integer.valueOf(time[0])*60+Integer.valueOf(time[1]);
            this.playTime=Integer.valueOf(plan[2]);
        }
       
    } 
    public String[] solution(String[][] plans) {
        int n =plans.length;
        int completeNum=0;
        String[] answer = new String[n];
        PriorityQueue<Work> job=new PriorityQueue<>((w1,w2)->Integer.compare(w1.start,w2.start));
        Stack<Work> stack=new Stack<>();
        
        for(String[] plan:plans){
            job.offer(new Work(plan));
        }
        
        
        while(!job.isEmpty()){
            Work work=job.poll();
            if(job.isEmpty()) {
                answer[completeNum++]=work.name;
                break;
            }
            Work nextWork=job.peek();
            int endTime=work.start+work.playTime;
            
            //기존 과제 안 끝남 -> 스택에 넣어
            if(nextWork.start<endTime){
                work.playTime=endTime-nextWork.start;
                stack.push(work);
            }else {
                answer[completeNum++]=work.name;
                if(nextWork.start==endTime) continue;
                int remainTime=nextWork.start-endTime;
                //기존 과제 끝남...stack 처리
                while(!stack.isEmpty()&&0<remainTime){
                    Work remainWork=stack.pop();
                    if(remainTime<remainWork.playTime){
                        remainWork.playTime-=remainTime;
                        stack.push(remainWork);
                        break;
                    }
                    answer[completeNum++]=remainWork.name;
                    remainTime-=remainWork.playTime;
                }
            }
            
        }
        while(!stack.isEmpty()){
            answer[completeNum++]=stack.pop().name;
        }
        
        
        
        
        return answer;
    }
}