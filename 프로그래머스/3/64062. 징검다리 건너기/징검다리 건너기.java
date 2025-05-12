import java.util.*;

class Solution {
    public class Data{
        int index;
        int value;
        public Data(int i,int v){
            this.index=i;
            this.value=v;
        }
    }
    public int solution(int[] stones, int k) {
        int n=stones.length;
        
        int ans=Integer.MAX_VALUE;
        ArrayDeque<Data> deque=new ArrayDeque<>();
        
        for(int i=0;i<n;i++){
            int stone=stones[i];
            
            //범위안에 있는것만 남기기
            while(!deque.isEmpty()&&k<i-deque.peekFirst().index+1){
                deque.pollFirst();
            }
            
            //지금 넣을 stone값보다 작은건 버리기(어차피 다음 비교에서도 최대가 아님)
            while(!deque.isEmpty()&&deque.peekLast().value<stone){
                deque.pollLast();
            }
                
            deque.offer(new Data(i,stone));
            if(k<=i+1){
                //k가 완성된 경우 정답과 비교
                ans=Math.min(ans,deque.peekFirst().value);
            
            }

        }
        
        
        return ans;
    }
}
