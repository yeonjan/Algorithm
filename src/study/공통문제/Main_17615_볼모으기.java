package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main_17615_볼모으기 {
    static int n, ans;
    static List<Ball> list = new ArrayList<>();
    static HashMap<Character, Integer> cntBall = new HashMap<>();

    static class Ball {
        int size;
        char color;

        Ball(int size, char color) {
            this.size = size;
            this.color = color;

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        char[] input = br.readLine().toCharArray();
        cntBall.put('R', 0);
        cntBall.put('B', 0);
        char pre = input[0];
        int cnt = 1;
        for (int i = 1; i <= input.length; i++) {
            char cur;
            if (i == input.length) cur = 'A';
            else cur = input[i];

            if (pre == cur) {
                cnt++;
                continue;
            }

            Ball ball;
            if (pre == 'R') {
                ball = new Ball(cnt, 'R');
                cntBall.replace('R', cnt + cntBall.get('R'));
            } else {
                ball = new Ball(cnt, 'B');
                cntBall.replace('B', cnt + cntBall.get('B'));
            }
            list.add(ball);
            pre = cur;
            cnt = 1;

        }
        ans = Math.min(cntBall.get('R'), cntBall.get('B'));

        Ball first = list.get(0);
        Ball last = list.get(list.size() - 1);
        if (first.color == last.color) {
            ans = Math.min(ans, cntBall.get(first.color) - Math.max(first.size, last.size));
        } else {
            int f = cntBall.get(first.color) - first.size;
            int l = cntBall.get(last.color) - last.size;
            ans = Math.min(f, l);
        }
        System.out.println(ans);
    }
}
