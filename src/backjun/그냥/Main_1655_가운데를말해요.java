package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_1655_가운데를말해요 {
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> over = new PriorityQueue<>();
        PriorityQueue<Integer> under = new PriorityQueue<>(Collections.reverseOrder());


        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            //첫번째 값
            if (i == 1) {
                m = Integer.parseInt(br.readLine());
            } else {
                int value = Integer.parseInt(br.readLine());
                if (value >= m) {
                    over.add(value);
                    if (over.size() > under.size()+1) {
                        under.add(m);
                        m = over.poll();
                    }
                } else {
                    under.add(value);
                    if (over.size() < under.size() ) {
                        over.add(m);
                        m = under.poll();
                    }
                }
            }

            sb.append(m).append("\n");

        }
        System.out.println(sb);


    }
}
