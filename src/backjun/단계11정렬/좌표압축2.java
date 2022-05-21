package backjun.단계11정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 좌표압축2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i) {
            arr1[i] = Integer.parseInt(st.nextToken());
            arr2[i] = arr1[i];
        }

        Arrays.sort(arr2);

        //<num,rank>
        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 0;

        for (int i = 0; i < n; i++) {
            int temp = arr2[i];

            if (!map.containsKey(temp)) {
                map.put(temp, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;++i){
            sb.append(map.get(arr1[i])).append(" ");
        }
        System.out.println(sb);
    }
}
