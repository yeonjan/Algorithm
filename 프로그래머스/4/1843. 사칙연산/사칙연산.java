import java.util.*;
class Solution {
    public int solution(String arr[]) {
        int length=arr.length;
        int numSize=length/2+1;
        int[][] MAX= new int[numSize][numSize];
        int[][] MIN= new int[numSize][numSize];
        for(int i=0;i<numSize;i++){
            for(int j=0;j<numSize;j++){
                MAX[i][j]=Integer.MIN_VALUE;
                MIN[i][j]=Integer.MAX_VALUE;
                if(i==j){
                    MAX[i][i]=Integer.valueOf(arr[i*2]);
                    MIN[i][i]=Integer.valueOf(arr[i*2]);
                }
            }
            
        }
        
        for(int delta=1;delta<numSize;delta++){
            for(int i=0;i+delta<numSize;i++){
                int j=i+delta;
                for(int k=i;k<j;k++){
                    int midIdx=k*2+1;
                    
                    if(arr[midIdx].equals("-")) {
                        MAX[i][j]= Math.max(MAX[i][j],MAX[i][k]-MIN[k+1][j]);
                        MIN[i][j]= Math.min(MIN[i][j],MIN[i][k]-MAX[k+1][j]);
                    } else if(arr[midIdx].equals("+")) {
                        MAX[i][j]= Math.max(MAX[i][j],MAX[i][k]+MAX[k+1][j]);
                        MIN[i][j]= Math.min(MIN[i][j],MIN[i][k]+MIN[k+1][j]);
                    }
                    
                }
            }
        }
        
        int answer = -1;
        return MAX[0][numSize-1];
    }
}

