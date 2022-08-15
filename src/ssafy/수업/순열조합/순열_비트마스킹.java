package ssafy.수업.순열조합;

import java.util.Arrays;

public class 순열_비트마스킹 {
    static int[] arr = {1, 2, 3, 4, 5};
    static int N = 5;
    static int R = 3;

    static int[] selected = new int[R]; //뽑은 숫자 담을 공간

    public static void main(String[] args) {
        permutation(0,0);

    }

    //요소 하나를 뽑고 다음 요소 선택은 재귀로 넘김
    public static void permutation(int cnt, int flag) {
        if(cnt==R){
            System.out.println(Arrays.toString(selected));
            return;
        }

        //유도 파트(반복할 부분)
        for (int i = 0; i < N; i++) {
            //이미 이전의 선택한 요소의 경우 다음 요소를 고려
            if ((flag & 1 << i) > 0) continue;

            selected[cnt] = arr[i]; //요소 선택
            permutation(cnt + 1, flag | 1 << i); //다음 요소를 고려
        }
    }
}
