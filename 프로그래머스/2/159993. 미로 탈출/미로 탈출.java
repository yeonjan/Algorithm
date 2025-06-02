import java.util.*;
class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        int[] start=new int[2];
        int[] exit=new int[2];
        int[] lever=new int[2];
        int n=maps.length;
        int m=maps[0].length();
        String[][] map=new String[n][m];
        
        for(int i=0;i<n;i++){
            char[] input=maps[i].toCharArray();
            for(int j=0;j<m;j++){
                map[i][j]=String.valueOf(input[j]);
                switch(map[i][j]){
                    case "S":
                        start=new int[]{i,j};
                        break;
                    case "E":
                        exit=new int[]{i,j};
                        break;
                    case "L":
                        lever=new int[]{i,j};
                        break;
                }
            }
        }
        
        int toLever=bfs(n,m,start,lever,map);
        int toExit=bfs(n,m,lever,exit,map);
        
        
        
        
        return 0<=toLever&&0<=toExit?toLever+toExit:-1;
    }
//     return 이동횟수
    public int bfs(int n,int m,int[] start,int[] target,String[][] map){
        Queue<int[]> queue=new ArrayDeque<>();
        int[][] delta={{-1,0},{1,0},{0,-1},{0,1}};
        boolean[][] visited=new boolean[n][m];
        visited[start[0]][start[1]]=true;
        queue.offer(start);
        
        
        int move=0;
        boolean findTarget=false;
        FindTarget:
        while(!queue.isEmpty()){
            int cnt=queue.size();
            move++;
            
            for(int i=0;i<cnt;i++){
                int[] cur=queue.poll();
                for(int d=0;d<4;d++){
                    int dr=cur[0]+delta[d][0];
                    int dc=cur[1]+delta[d][1];
                    
                    if(dr<0||dc<0||dr>=n||dc>=m) continue;
                    
                    if(!visited[dr][dc]&&!map[dr][dc].equals("X")){
                        //내가 찾는거면 더 안찾고 끝내!!
                        if(dr==target[0]&&dc==target[1]){
                            findTarget=true;
                            break FindTarget;
                        }
                        
                        visited[dr][dc]=true;
                        queue.offer(new int[]{dr,dc});
                        
                    }
                }
            }
        }
        
        
        
        return findTarget?move:-1;
    }
}
//레버로 이동(최소), 출구로 이동(최소)