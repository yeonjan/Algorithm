package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10431_줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int p = Integer.parseInt(br.readLine());
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            sb.append(n).append(" ");

            int count = 0;
            int[] arr = new int[20];
            arr[0] = Integer.parseInt(st.nextToken());
            for (int j = 1; j < 20; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                for (int k = j; k > 0; k--) {
                    if (arr[k] < arr[k - 1]) {
                        int temp = arr[k];
                        arr[k] = arr[k - 1];
                        arr[k - 1] = temp;
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb.toString());


    }
}

// 900

//지금 들어가는 애 보다 큰 애들이 얼마나 있는지만 세면 됨.
//힙정렬

//1 19 20 17 18 15 16 13 14 11 12 9 10 7 8 5 6 3 4 1 2
//15 17 18 19 20

//2 + 2 + 4