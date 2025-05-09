import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int MAX_NUM = 100000;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //앞에서부터 하나씩 카운트.. arr에 갯수 카운트 하면될듯?
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] sequence = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int ans = getMaxSeq(sequence, N, K);
        System.out.println(ans);


    }

    public static int getMaxSeq(int[] sequence, int N, int K) {
        int[] count = new int[MAX_NUM + 1];
        int length = 0;
        int left = 0;
        int right = 0;
        while (left <= right) {
            if (count[sequence[right]] + 1 <= K) {
                length = Math.max(length, right - left+1);
                count[sequence[right]]++;
                right++;
                right = Math.min(right, N - 1);
            } else {
                count[sequence[left]]--;
                left++;
                if (right < left) {
                    right = Math.min(left, N - 1);
                }
            }


        }
        return length;
    }


}

