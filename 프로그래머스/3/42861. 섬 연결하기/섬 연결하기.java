import java.util.*;
class Solution {
    static int[][] adj;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        adj=new int[n][n];
        for(int[] cost:costs){
            adj[cost[0]][cost[1]]=cost[2];
            adj[cost[1]][cost[0]]=cost[2];
        }
        answer=solve(n);
        
        return answer;
    }
    public int solve(int n){
        int totalCost=0;
        boolean[] visited=new boolean[n];
        PriorityQueue<int[]> pq= new PriorityQueue<>((o1,o2)->Integer.compare(o1[1],o2[1]));
        
        pq.offer(new int[]{0,0});
        while(!pq.isEmpty()){
            int[] poll=pq.poll();
            int node=poll[0];
            int cost=poll[1];
            if(visited[node]) continue;
            totalCost+=cost;
            visited[node]=true;
            
            for(int next=0;next<n;next++){
                if(adj[node][next]==0) continue;
                if(visited[next]) continue;
                pq.offer(new int[]{next,adj[node][next]});
                
                
            }
        }
        return totalCost;
        
    }
}  
// 0 1 2 1
// - - - -