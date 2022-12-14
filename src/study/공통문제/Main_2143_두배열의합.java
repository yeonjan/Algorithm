package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2143_두배열의합 {
    static int T, n, m;
    static int[] prefixSumA, prefixSumB;
    static HashMap<Integer, Integer> cntA = new HashMap<>(), cntB = new HashMap<>();
    static List<Integer> a = new ArrayList<>(), b = new ArrayList<>();
    static long ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        //a입력
        n = Integer.parseInt(br.readLine());

        //배열 a의 부분합 구하기
        prefixSumA = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            prefixSumA[i] = prefixSumA[i - 1] + Integer.parseInt(st.nextToken());
        }

        //b입력
        m = Integer.parseInt(br.readLine());

        //배열 b의 부분합 구하기
        prefixSumB = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            prefixSumB[i] = prefixSumB[i - 1] + Integer.parseInt(st.nextToken());
        }

        //a의 부 배열의 합으로 나올 수 있는 모든 수 찾기
        for (int start = 1; start <= n; start++) {
            for (int end = start; end <= n; end++) {
                int subSet = prefixSumA[end] - prefixSumA[start - 1];
                Integer cnt = cntA.get(subSet);
                if (cnt == null) {
                    a.add(subSet);
                    cntA.put(subSet, 1);
                } else cntA.replace(subSet, cnt + 1);
            }
        }

        //b의 부 배열의 합으로 나올 수 있는 모든 수 찾기
        for (int start = 1; start <= m; start++) {
            for (int end = start; end <= m; end++) {
                int subSet = prefixSumB[end] - prefixSumB[start - 1];
                Integer cnt = cntB.get(subSet);
                if (cnt == null) {
                    b.add(subSet);
                    cntB.put(subSet, 1);
                } else cntB.replace(subSet, cnt + 1);
            }
        }

        Collections.sort(a);
        Collections.sort(b);

        for (Integer valueA : a) {
            int idx = Collections.binarySearch(b, T - valueA);
            if (idx >= 0) {
                Integer valueB = b.get(idx);
                ans += (long) cntA.get(valueA) * cntB.get(valueB);
            }
        }

        System.out.println(ans);

    }
}
