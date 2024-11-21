import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;
    static int[] target = new int[2];

    static class Triangle {
        int a, b, c;

        Triangle(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        String getType() {
            int max = Math.max(a, Math.max(b, c));
            if (max >= a + b + c - max) {
                return "Invalid";
            }

            if (a == b && b == c) {
                return "Equilateral";
            } else if (a == b || b == c || a == c) {
                return "Isosceles";
            } else {
                return "Scalene";
            }
        }

        boolean isEnded() {
            return a == 0 && b == 0 && c == 0;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            Triangle triangle = new Triangle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            if (triangle.isEnded()) break;
            sb.append(triangle.getType()).append("\n");
        }
        System.out.println(sb.toString());
    }

}