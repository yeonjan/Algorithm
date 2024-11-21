import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int delta = 6;
        int i = 0;
        int num = 1;
        while (N > num + (delta * i)) {
            num += (delta * i) ;
            i++;


        }
        System.out.println(i + 1);


    }

}