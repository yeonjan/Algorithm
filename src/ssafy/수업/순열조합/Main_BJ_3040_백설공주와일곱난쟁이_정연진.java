package ssafy.수업.순열조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_3040_백설공주와일곱난쟁이_정연진 {
    static int[] arr = new int[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            total += arr[i];
        }

        total -= 100;

        Find:
        for (int i = 0; i < 8; i++) {
            for (int j = i; j < 9; j++) {
                if (arr[i] + arr[j] == total) {
                    for(int k=0;k<9;k++){
                        if(k!=i&&k!=j) System.out.println(arr[k]);
                    }
                    break Find;
                }
            }
        }



    }

}
