import java.util.*;
class Solution {
    private int SIZE=102;
    private int ans=Integer.MAX_VALUE;
    private int[][] map=new int[SIZE][SIZE]; //1:사각형내부 2:테두리
    private int[][] delta={{-1,0},{1,0},{0,-1},{0,1}};
    private boolean[][] visited=new boolean[SIZE][SIZE];
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int maxR=0;
        int maxC=0;
        int cnt=0;
        
        //1. 사각형 그리기(테두리 표시!)
        for(int[] rect:rectangle){
            int leftC=rect[0]*2;
            int leftR=rect[1]*2;
            int rightC=rect[2]*2;
            int rightR=rect[3]*2;
            maxR=Math.max(maxR,rightR);
            maxC=Math.max(maxC,rightC);
            for(int r=leftR;r<=rightR;r++){
                for(int c=leftC;c<=rightC;c++){
                    if(map[r][c]==1) continue;
                    map[r][c]=1;
                    if(c==leftC||c==rightC||r==leftR||r==rightR) {
                        map[r][c]=2;
                        cnt++;
                    }
                }
            }
        }
 
        
        return bfs(characterX*2, characterY*2, itemX*2, itemY*2);
    }


    public int bfs(int characterX, int characterY, int itemX, int itemY){
        Queue<int[]> q=new ArrayDeque<>();
        boolean[][] visited=new boolean[SIZE][SIZE];
        int[][] delta={{-1,0},{1,0},{0,-1},{0,1}};
        q.offer(new int[]{characterY,characterX,0});
        visited[characterY][characterX]=true;
        
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int cnt=cur[2];
            if(cur[0]==itemY&&cur[1]==itemX) {
                return cnt/2;
            }
            
            for(int d=0;d<4;d++){
                int dr=cur[0]+delta[d][0];
                int dc=cur[1]+delta[d][1];
                if(dr<0||dc<0||dr>=SIZE||dc>=SIZE) continue;
                if(visited[dr][dc]||map[dr][dc]!=2) continue;
                
                q.offer(new int[]{dr,dc,cnt+1});
                visited[dr][dc]=true;
            }

            
            
            
        }
        return 0;
    }
 

}