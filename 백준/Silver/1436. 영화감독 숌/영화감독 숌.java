import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int n = 1;
        int num = 666;
        while (n < N) {
            num ++;
            String title = String.valueOf(num);
            if (title.contains("666")) {
                n++;
            }
        }
        System.out.println(num);

    }


}