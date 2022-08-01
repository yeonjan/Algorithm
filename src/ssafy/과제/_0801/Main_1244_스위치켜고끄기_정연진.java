package ssafy.과제._0801;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_1244_스위치켜고끄기_정연진 {
    static int n;
    static String[] light;
    static int studentSize;
    static int[][] student;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        light = ("null " + br.readLine()).split(" ");
        studentSize = Integer.parseInt(br.readLine());
        student = new int[studentSize][2];

        //학생 입력받아 실행
        for (int i = 0; i < studentSize; i++) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 1) boyChange(Integer.parseInt(st.nextToken()));
            else girlChange(Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= n; i++) {
            sb.append(light[i] + " ");
            if (i % 20 == 0) sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void boyChange(int num) {
        for (int i = num; i < light.length; i += num) {
            lightChange(i);
        }
    }

    public static void girlChange(int num) {
        lightChange(num);

        int size = light.length - 1;
        if (size <= 2) return;

        int range = size % 2 == 0 ? Math.min(size - num, num - 1) : size - num;
        for (int i = 1; i <= range; i++) {
            if (light[num - i].equals(light[num + i])) {
                lightChange(num - i);
                lightChange(num + i);
            } else break;
        }
    }

    public static void lightChange(int i) {
        if (light[i].equals("0")) light[i] = "1";
        else light[i] = "0";

    }
}
