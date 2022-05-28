package SWExpertAcademy;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 회문11 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {
            int n = Integer.parseInt(br.readLine());

            int count = 0;
            String[][] input = new String[8][8];
            for (int i = 0; i < 8; i++) {
                input[i] = br.readLine().split("");
            }

            for (int h = 0; h < 8; h++) {
                for (int i = 0; i < 9 - n; i++) {
                    String[] row = new String[n];
                    String[] columm = new String[n];

                    for (int l = 0; l < n; l++) {
                        row[l] = input[h][i+l];
                        columm[l] = input[i+l][h];
                    }
                    count += isRight(row);
                    count += isRight(columm);
                }

            }
            System.out.println("#" + test_case + " " + count);
        }
    }

    public static int isRight(String[] arr) {
        int count = 0;
        int size = arr.length;
        for (int i = 0; i < size / 2; i++) {
            if (arr[i].equals(arr[size - 1 - i])) {
                count++;
            }
        }
        if (count == size / 2) {

            return 1;
        }
        return 0;

    }
}
