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
        char cur, pre = input[0];
        int cntR = 0, cntB = 0, cnt = 1;
        for (int i = 1; i <= input.length; i++) {

            if (i == input.length) cur = 'A';
            else cur = input[i];

            //이전 볼과 현재볼의 색이 같을 떄
            if (pre == cur) {
                cnt++;
                continue;
            }
            //이전 볼과 현재볼의 색이 다를 떄
            if (pre == 'R') {
                list.add(new Ball(cnt, 'R'));
                cntR += cnt;
            } else {
                list.add(new Ball(cnt, 'B'));
                cntB += cnt;
            }

            pre = cur;
            cnt = 1;
        }

        cntBall.put('R', cntR);
        cntBall.put('B', cntB);

        ans = Math.min(cntR, cntB);

        //첫번째 공과 마지막 공 더미
        Ball first = list.get(0);
        Ball last = list.get(list.size() - 1);
        //색이 같을 때
        if (first.color == last.color) {
            ans = Math.min(ans, cntBall.get(first.color) - Math.max(first.size, last.size));
        }
        //색이 다를 때
        else {
            int f = cntBall.get(first.color) - first.size;
            int l = cntBall.get(last.color) - last.size;
            ans = Math.min(f, l);
        }
        System.out.println(ans);
    }
}
