package backjun.단계11정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 좌표압축 {
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        int[] tempNums = new int[n];

        for (int i = 0; i < n; ++i) {
            tempNums[i] = Integer.parseInt(nums[i]);
        }
        Arrays.sort(tempNums);
        array = Arrays.stream(tempNums).distinct().toArray();

        StringBuilder sb = new StringBuilder();

        //이분탐색
        for (String num : nums) {
            sb.append(binarySearch(Integer.parseInt(num), 0, array.length)).append(" ");
        }
        System.out.println(sb);
    }

    public static int binarySearch(int target, int start, int end) {
        int mid = (start + end) / 2;
        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            return binarySearch(target, start, mid - 1);
        } else {
            return binarySearch(target, mid + 1, end);
        }
    }
}
