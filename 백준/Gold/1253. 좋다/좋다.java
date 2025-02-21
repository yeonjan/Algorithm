import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n;
    static int count = 0;
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Long.parseLong(st.nextToken()));
        }
        Collections.sort(list);

        for (int i = 0; i < n; i++) {
            Long num = list.get(i);
            if (isGood(0, n - 1, i)){
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean isGood(int left, int right, int idx) {
        Long target = list.get(idx);
        while (left < right) {
            if (idx == left) {
                left++;
                continue;
            }
            if (idx == right){
                right--;
                continue;
            }


            Long sum = list.get(left) + list.get(right);
            if (sum.equals(target)) return true;
            else if (sum < target) left++;
            else right--;
        }
        return false;

    }


}