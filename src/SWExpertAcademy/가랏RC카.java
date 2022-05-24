package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가랏RC카 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            int speed = 0;
            int dist = 0;
            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int command = Integer.parseInt(st.nextToken());
                switch (command) {
                    case 1:
                        speed += Integer.parseInt(st.nextToken());
                        dist += speed;
                        break;
                    case 2:
                        speed -= Integer.parseInt(st.nextToken());
                        if(speed<0) speed=0;
                        dist += speed;

                        break;
                    case 0:
                        dist += speed;
                }
            }
                System.out.println("#"+test_case+" "+dist);

        }
    }
}
