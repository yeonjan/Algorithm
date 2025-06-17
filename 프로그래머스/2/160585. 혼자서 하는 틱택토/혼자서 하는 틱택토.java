import java.util.*;
class Solution {
    public int solution(String[] board) {
        int answer = 1;
        int[] countInfo=new int[2];
        boolean[] isEnd=new boolean[2];
        
        int[][] map=getMap(board);
        isEnd[0]=getEndState(0,map);
        isEnd[1]=getEndState(1,map);
        count(map,countInfo);
        
        //정상적인 상황
        //선공=0 후공=0
        //선공>=후공 &&
        
        if(countInfo[0]<countInfo[1]) answer=0;
        else if(isEnd[0]&&countInfo[0]!=countInfo[1]+1) answer=0;
        else if(isEnd[1]&&countInfo[0]!=countInfo[1]) answer=0;
        else if(isEnd[0]&&isEnd[1]) answer=0;
        else if(!isEnd[0]&&!isEnd[1]&&2<=countInfo[0]-countInfo[1]) answer=0;
        return answer;
    }
    public void count(int[][] map,int[] countInfo){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(0<=map[i][j]) countInfo[map[i][j]]++;
            }
        }
    }
    public int[][] getMap(String[] board){
        int[][] map=new int[3][3];
        for(int i=0;i<3;i++){
            char[] input =board[i].toCharArray();
            for(int j=0;j<3;j++){
                if(input[j]=='X') map[i][j]=1;
                else if(input[j]=='.') map[i][j]=-1;;
            }
        }
        return map;
    }
    public boolean getEndState(int num,int[][] map){
        int cntR=0;
        int cntC=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(map[i][j]==num) cntR++;
                if(map[j][i]==num) cntC++;
            }
            if(cntR==3||cntC==3) return true;
            else {
                cntR=0;
                cntC=0;
            }
        }
        cntR=0;
        cntC=0;
        
        for(int i=0;i<3;i++){
            if(map[i][i]==num) cntR++;
            if(map[i][2-i]==num) cntC++;
        }
        if(cntR==3||cntC==3) return true;
        
        return false;
        
    }
}
//0.X
//.0.
//..X

//1) 게임이 종료되었는지 -> 선공이 종료되었으면 후공은 선공==후공일 수 없음
//2) OX 수가 맞는지

// 성공,후공 개수
// if(선공<후공) 불가능
// if(선공<=후공 && 선공 종료) 불가능
// if(선공==0&&후공==0) 가능
// 선공 or 후공이 종료되었는지