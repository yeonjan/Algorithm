import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int len = commands.length;
        int[] answer = new int[len];
        int[] mini={};
        for(int i=0;i<len;i++){
            mini = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            answer[i]=sort(mini,commands[i][2]);
        }
        return answer;
    }
    public int sort(int[] arr,int k){
        int len = arr.length;
        int[] before = new int[100];
        int[] after = new int[len];
        int indx=0;
        
        for(int i=0;i<len;i++){
            before[arr[i]]++;
        }
        
        for(int i=0;i<100;i++){
            if(before[i]!=0){
                for(int j=0;j<before[i];j++){
                    after[indx+j]=i;
                }
                indx+=before[i];
            }
        }
        return after[k-1];
    }
}