import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n, c;
    static List<Integer> list = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            list.add(a);
        }
        Collections.sort(list);

        int low = 1, high = list.get(list.size() - 1) - list.get(0)+1;
        while (low < high) {
            int mid = (low + high) / 2;

            int count = calcCanInstall(mid);
            if (count >= c) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        System.out.println(low - 1);


    }

    public static int calcCanInstall(int distance) {
        int cnt = 1;
        int last = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            int next = list.get(i);
            if (next - last >= distance) {
                last = next;
                cnt++;
            }
        }
        return cnt;
    }


}