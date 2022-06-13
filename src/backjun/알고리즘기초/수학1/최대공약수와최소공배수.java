package backjun.알고리즘기초.수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대공약수와최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        //방법1
       /* int min = Math.min(a, b);
        int GCD = 1; //최대공약수
        int LCM = 1; //최소공배수

        int d = 2;
        while (true) {
            if (min < d) {
                break;
            }
            if (a % d == 0 && b % d == 0) {
                GCD *= d;
                a /= d;
                b /= d;
            } else {
                d++;
            }
        }
        LCM = GCD * a * b;
*/
        //방법2 유클리드 호제법
        int GCD = gcd(a, b);
        int LCM = (a * b) / GCD;

        System.out.println(GCD);
        System.out.println(LCM);

    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);

    }
}
