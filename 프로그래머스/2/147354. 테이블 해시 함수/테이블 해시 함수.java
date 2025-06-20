import java.util.*;
class Solution {
    class Table{
        int[][] data;
        int hash;
        public Table(int[][] data, int col, int row_begin, int row_end ){
            this.data=data;
            this.hash=getHash(col-1,row_begin,row_end);
        }
        private int getHash(int col, int row_begin, int row_end){
            //정렬
            PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->{
                if(o1[col]==o2[col]){
                    return -Integer.compare(o1[0],o2[0]);
                }
                return Integer.compare(o1[col],o2[col]);
            });
            
            for(int[] tuple:data){
                pq.offer(tuple);
            }
            
            //S 구하기
            int[] S=new int[data.length+1];
            for(int i=1;i<=data.length;i++){
                int[] tuple=pq.poll();
                for(int field:tuple){
                    S[i]+=field%i;
                }
            }
            
            //XOR
            int ans=0;
            for(int i=row_begin;i<=row_end;i++){
                ans^=S[i];
            }
            return ans;
        }
        private void sortData(){
            
        }
    }
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Table table=new Table(data,col,row_begin,row_end);
        
        return table.hash;
    }
}