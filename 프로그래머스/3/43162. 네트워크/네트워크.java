class Solution {
    static boolean[] visit;
    public int solution(int n, int[][] adj) {
        int ans = 0;
        visit=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visit[i]) {
                visit[i]=true;
                dfs(adj,i);
                ans++;
            }
        }
        return ans;
    }
    public void dfs(int[][] adj,int num){
        for(int i=0;i<adj.length;i++){
            if(adj[num][i]==1&&!visit[i]){
                visit[i]=true;
                dfs(adj,i);
            }
        }
    }
}