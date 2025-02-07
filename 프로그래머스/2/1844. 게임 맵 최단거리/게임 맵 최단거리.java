import java.util.*;
class Solution {
    static int[][] delta={{-1,0},{1,0},{0,-1},{0,1}};
    static int n,m;
    static boolean[][] visited;
    public int solution(int[][] maps) {
        n=maps.length;
        m=maps[0].length;
        visited=new boolean[n][m];
        
        
        int answer = bfs(maps);
        return answer;
    }
    public int bfs(int[][] map){
        Queue<int[]> queue=new ArrayDeque<>();
        visited[0][0]=true;
        queue.offer(new int[]{0,0,1});
        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            if(cur[0]==n-1&&cur[1]==m-1) return cur[2];
            for(int d=0;d<4;d++){
                int dr=cur[0]+delta[d][0];
                int dc=cur[1]+delta[d][1];
                
                if(dr<0||dc<0||dr>=n||dc>=m) continue;
                if(map[dr][dc]==0) continue;
                if(!visited[dr][dc]){
                    visited[dr][dc]=true;
                    queue.offer(new int[]{dr,dc,cur[2]+1});
                }
                
            }
        }
        return -1;
        
    }
}