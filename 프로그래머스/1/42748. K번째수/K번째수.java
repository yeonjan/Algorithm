import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0;i<commands.length;i++){
            answer[i]=getNum(array,commands[i]);
        }
        return answer;
    }
    public int getNum(int[] arr,int[] commands){
        List<Integer> list=new ArrayList<>();
        for(int i=commands[0]-1;i<commands[1];i++){
            list.add(arr[i]);
        }
        Collections.sort(list);
        return list.get(commands[2]-1);
    }
}