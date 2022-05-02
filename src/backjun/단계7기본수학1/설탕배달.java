package backjun.단계7기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 설탕배달 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dynamic = new int[n + 1];
        int[] defaultNum = {-1, -1, -1, 1, -1, 1, 2, -1};

        if (n < 8) {
            System.out.println(defaultNum[n]);
            return;
        } else {
            for (int i = 0; i < 8; ++i) {
                dynamic[i] = defaultNum[i];
            }
        }
        for (int i = 8; i <= n; ++i) {
            if (dynamic[i - 3] != -1 && dynamic[i - 5] != -1) {
                dynamic[i] = 1 + Math.min(dynamic[i - 3], dynamic[i - 5]);
            } else if (dynamic[i - 3] != -1 && dynamic[i - 5] == -1) {
                dynamic[i] = 1 + dynamic[i - 3];
            }else if (dynamic[i - 3] == -1 && dynamic[i - 5] != -1) {
                dynamic[i] = 1 + dynamic[i - 5];
            }
        }
        System.out.println(dynamic[n]);


    }
}
