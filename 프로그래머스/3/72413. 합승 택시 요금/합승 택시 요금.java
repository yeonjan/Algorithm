import java.util.*;
class Solution {
    static int MAX_VALUE=20000000; 
    static int[][] minDist;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] adj=new int[n+1][n+1];
        minDist=new int[n+1][n+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==j) minDist[i][j]=0;
                else minDist[i][j]=MAX_VALUE;
            }
        }
        
        for(int[] fare:fares){
            adj[fare[0]][fare[1]]=fare[2];
            adj[fare[1]][fare[0]]=fare[2];
        }
        
        dijkstra(adj,s,n);
        dijkstra(adj,a,n);
        dijkstra(adj,b,n);
        
        int ans=Integer.MAX_VALUE;
        //최소값
        for(int mid=1;mid<=n;mid++){
            ans=Math.min(ans,minDist[s][mid]+minDist[mid][a]+minDist[mid][b]);
        }
        
        return ans;
    }
    public void dijkstra(int[][] adj,int s,int n){
        PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->Integer.compare(o1[1],o2[1]));//next,dist
        pq.offer(new int[]{s,0});
        
        while(!pq.isEmpty()){
            int[] polled = pq.poll();
            int cur=polled[0];
            int dist=polled[1];
            for(int next=1;next<=n;next++){
                if(adj[cur][next]==0) continue;
                if(dist+adj[cur][next]<minDist[s][next]){
                    minDist[s][next]=dist+adj[cur][next];
                    minDist[next][s]=dist+adj[cur][next];
                    pq.offer(new int[]{next,minDist[s][next]});
                }
            
            }
            
        }
        
    }

}