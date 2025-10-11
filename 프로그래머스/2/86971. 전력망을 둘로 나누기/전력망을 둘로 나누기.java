import java.util.*;
class Solution {
    static int[][] adj;
    public int solution(int n, int[][] wires) {
        int ans = Integer.MAX_VALUE;
        adj=new int[n+1][n+1];
        for(int[] wire:wires){
            adj[wire[0]][wire[1]]=1;
            adj[wire[1]][wire[0]]=1;
        }
        
        for(int[] wire:wires){
            adj[wire[0]][wire[1]]=0;
            adj[wire[1]][wire[0]]=0;
            ans=Math.min(ans,Math.abs(count(wire[0],n)-count(wire[1],n)));
            adj[wire[0]][wire[1]]=1;
            adj[wire[1]][wire[0]]=1;
        }
        return ans;
    }
    public int count(int node,int n){
        ArrayDeque<Integer> queue=new ArrayDeque<>();
        int cnt=1;
        boolean[] visited=new boolean[n+1];
        queue.offer(node);
        visited[node]=true;
        while(!queue.isEmpty()){
            int poll=queue.poll();
            for(int next=1;next<=n;next++){
                if(adj[poll][next]==0) continue;
                if(!visited[next]){
                    visited[next]=true;
                    cnt++;
                    queue.offer(next);
                }
                
            }
        }
        return cnt;
    }
}
//99*100