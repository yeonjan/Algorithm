import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n, m;
    static List<Name> list = new ArrayList<>();


    static class Name implements Comparable<Name> {
        String name;
        int power;
        int idx;

        public Name(String n, int p, int i) {
            this.name = n;
            this.power = p;
            this.idx = i;
        }

        @Override
        public int compareTo(Name o) {
            if (this.power == o.power) {
                return Integer.compare(this.idx, o.idx);
            }
            return Integer.compare(this.power, o.power);
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            list.add(new Name(input[0], Integer.parseInt(input[1]), i));
        }

        Collections.sort(list);

        for (int i = 0; i < m; i++) {
            int power = Integer.parseInt(br.readLine());
            sb.append(getStyle(power)).append("\n");
        }

        System.out.println(sb);

    }

    public static String getStyle(int target) {
        int low = 0;
        int high = n;
        while (low < high) {
            int mid = (low + high) / 2;
            int midVal = list.get(mid).power;
            if (midVal >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return list.get(low).name;
    }


}