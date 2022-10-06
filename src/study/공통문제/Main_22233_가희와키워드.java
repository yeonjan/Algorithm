package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_22233_가희와키워드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            map.put(br.readLine(), 1);
        }
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(",");
            for (String s : input) {
                if (map.containsKey(s)) map.remove(s);
            }
            sb.append(map.size()).append("\n");
        }

        System.out.println(sb);

    }
}
