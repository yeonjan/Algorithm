class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        
        for(int d=0;d<4;d++){
            if(canOpen(key,lock)){
                answer=true;
                break;
            }
            rotate(key);
        }
        return answer;
    }
  
    public void rotate(int[][] key){
        int m=key.length;
        int[][] key2=new int[m][m];
        for(int i=0;i<m;i++){
            key2[i]=key[i].clone();
        }
        
        for(int r=0;r<m;r++){
            for(int c=0;c<m;c++){
                key[r][c]=key2[m-c-1][r];
            }
        }
    }
    public boolean canOpen(int[][] key, int[][] lock){
        int cnt=0;
        int m=key.length;
        int n=lock.length;
        int expendSize=n+(2*m);
        int[][] largeLock=new int[expendSize][expendSize];
        int[] range=new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE,0,0};
        
        for(int i=0;i<expendSize;i++){
            for(int j=0;j<expendSize;j++){
                if(m<=i&&m<=j&&i<m+n&&j<m+n)largeLock[i][j]=lock[i-m][j-m];
                else largeLock[i][j]=-1;
                
                if(largeLock[i][j]==0) {
                    cnt++;
                    range[0]=Math.min(range[0],i);
                    range[1]=Math.min(range[1],j);
                    range[2]=Math.max(range[2],i);
                    range[3]=Math.max(range[3],j);
                }
            }
        }
      
      
        //매치
        if(cnt==0) return true;
        for(int startR=range[0]-m+1;startR<range[2]+1;startR++){
            for(int startC=range[1]-m+1;startC<range[3]+1;startC++){
                int countSolve=0;
                
                findKey:
                for(int dr=0;dr<m;dr++){
                    for(int dc=0;dc<m;dc++){
                        if(largeLock[startR+dr][startC+dc]==0&&key[dr][dc]==1){
                            countSolve++;
                        }
                        if(largeLock[startR+dr][startC+dc]==key[dr][dc]){
                            countSolve=0;
                            break findKey;
                        }
                        
                    }
                }
                
                if(countSolve==cnt) return true;
            }
            
        }
        
        
        return false;
        
    }
}

//20*20 
//0. 방향설정
//1. 키에서 돌기가 있는 부분만 탐색 n*n
//2. 키를 회전하면 lock의 홈에 해당하는지 탐색 n*n
// 4*(20^4)