class Solution {
    static int MAX_VALUE=20000000; 
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] dist=new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(i==j)dist[i][j]=0;
                else dist[i][j]=MAX_VALUE;
            }
        }
        for(int[] fare:fares){
            dist[fare[0]][fare[1]]=fare[2];
            dist[fare[1]][fare[0]]=fare[2];
        }
        
        //벨만포드
        for(int mid=1;mid<=n;mid++){
            for(int start=1;start<=n;start++){
                for(int end=1;end<=n;end++){
                    if(dist[start][mid]+dist[mid][end]<dist[start][end]){
                        dist[start][end]=dist[start][mid]+dist[mid][end];
                    }
                    
                }
            }
        }
        
        int ans=Integer.MAX_VALUE;
        //최소값
        for(int mid=1;mid<=n;mid++){
            ans=Math.min(ans,dist[s][mid]+dist[mid][a]+dist[mid][b]);
        }
        
        return ans;
    }
}