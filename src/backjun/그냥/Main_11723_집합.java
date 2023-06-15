package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11723_집합 {
    static int[] arr = new int[21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int M = Integer.parseInt(br.readLine());


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String opt = st.nextToken();
            int x=0;
            if(st.hasMoreTokens()){
                x= Integer.parseInt(st.nextToken());
            }


            if (opt.equals("add") && arr[x] == 0) {
                arr[x]++;
            } else if (opt.equals("remove")) {
                arr[x] = 0;
            } else if (opt.equals("check")) {
                sb.append(arr[x]).append("\n");
            } else if (opt.equals("toggle")) {
                arr[x] = -(arr[x] - 1);
            } else if (opt.equals("all")) {
                for (int j = 1; j <= 20; j++) {
                    arr[j] = 1;
                }
            }else if(opt.equals("empty")){
                for (int j = 1; j <= 20; j++) {
                    arr[j] = 0;
                }
            }


        }
        System.out.println(sb.toString());


    }

}

