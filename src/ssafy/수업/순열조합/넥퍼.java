package ssafy.수업.순열조합;

import java.util.Arrays;

public class 넥퍼 {
    static int[] arr = {3, 5, 4, 1, 2};

    //5P5
    public static void main(String[] args) {
        //가장 작은 숫자로 정렬
        Arrays.sort(arr);

        do {
            System.out.println(Arrays.toString(arr));
        } while (np(arr));


    }

    //현재 순열에서 다음으로 큰 순열을 만들어 줌
    private static boolean np(int[] arr) {
        int N = arr.length;

        //1. 꼭대기 인덱스 찾기
        int i = N - 1; //꼭대기 인덱스
        while (i > 0 && arr[i - 1] >= arr[i]) i--;

        //꼭대기 인덱스가 0이라면? 모든 수가 내려가는 구간이므로 이미 가장 큰 수
        if (i == 0) return false;

        //2. (i-1) 요소와 교환할 요소의 인덱스 찾기
        int j = N - 1;
        while (arr[i - 1] >= arr[j]) j--;

        //3. (i-1) <=> 요소 스왑
        swap(arr, i - 1, j);

        //4. (i~ N-1) 요소들을 오름차순으로 정렬
        //i는 앞의 요소의 포인터, k는 뒤의 요소의 포인터
        int k = N - 1;
        while (i < k) {
            swap(arr, i++, k--);
        }

        //큰 순열을 만들어내는데 성공했으므로 true
        return true;
    }

    //배열의 i,j를 스왑
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }
}
