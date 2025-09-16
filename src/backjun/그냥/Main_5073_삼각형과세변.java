package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_5073_삼각형과세변 {
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            nums = new int[3];
            nums[0] = Integer.parseInt(st.nextToken());
            nums[1] = Integer.parseInt(st.nextToken());
            nums[2] = Integer.parseInt(st.nextToken());

            Arrays.sort(nums);

            if (check()) {
                break;
            }


            if (isInvalid()) {
                sb.append("Invalid").append("\n");
            } else if (isEquilateral()) {
                sb.append("Equilateral").append("\n");
            } else if (isIsosceles()) {
                sb.append("Isosceles").append("\n");
            } else {
                sb.append("Scalene").append("\n");
            }
        }
        System.out.println(sb.toString());

    }

    public static boolean check() {
        return nums[0] == 0 && nums[1] == 0 && nums[2] == 0;

    }

    public static boolean isEquilateral() {
        return (nums[0] == nums[1]) && (nums[1] == nums[2]);

    }

    public static boolean isIsosceles() {
        return (nums[0] == nums[1]) || (nums[1] == nums[2]) || nums[0] == nums[2];
    }

    public static boolean isInvalid() {
        return (nums[0] + nums[1]) <= nums[2];
    }


}
