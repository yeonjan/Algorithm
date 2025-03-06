import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n;
    static int center = 0;
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            list.add(new int[]{l, h});

        }
        list.sort(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < list.size(); i++) {
            if (list.get(center)[1] < list.get(i)[1]) {
                center = i;
            }
        }
        int sum = getSum();
        System.out.println(sum);


    }

    private static int getSum() {
        int sum = 0;


        int highIdx = 0;
        //왼쪽
        for (int i = 1; i <= center; i++) {
            if (list.get(highIdx)[1] <= list.get(i)[1]) {
                sum += (list.get(i)[0] - list.get(highIdx)[0]) * list.get(highIdx)[1];
                highIdx = i;
            }
        }
        sum += list.get(center)[1];

        //오른쪽
        highIdx = list.size() - 1;
        for (int i = list.size() - 2; i >= center; i--) {
            if (list.get(highIdx)[1] <= list.get(i)[1]) {
                sum += (list.get(highIdx)[0] - list.get(i)[0]) * list.get(highIdx)[1];
                highIdx = i;
            }
        }
        return sum;
    }

    public static void dfs(int idx, int h, int sum) {
        int[] column = list.get(idx);

    }


}