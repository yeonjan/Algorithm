package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2042_구간합구하기 {
    static int n, m, k;

    static long[] inputList, segmentTree;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        inputList = new long[n + 1];
        segmentTree = new long[n *4];
        for (int i = 1; i <= n; i++) {
            inputList[i] = Long.parseLong(br.readLine());
        }
        makeSegmentTree(1, n, 1);
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if (a == 1) changeValue(1, n, 1, b, c);
            else {
                long prefixSum = getPrefixSum(1, n, 1, b, c);
                System.out.println(prefixSum);
            }
        }

    }

    public static long getPrefixSum(int startIndex, int endIndex, int idx, int from, long to) {

        //인덱스가 완전하게 포함
        if (startIndex >= from && endIndex <= to) {
            return segmentTree[idx];
        }
        //인덱스 범위 아예 포함 x
        if (endIndex < from || startIndex > to) {
            return 0;
        }

        int midIndex = (startIndex + endIndex) / 2;
        long leftSum = getPrefixSum(startIndex, midIndex, idx * 2, from, to);
        long rightSum = getPrefixSum(midIndex + 1, endIndex, idx * 2 + 1, from, to);

        return leftSum + rightSum;
    }

    public static long changeValue(int startIndex, int endIndex, int idx, int targetIdx, long value) {

        //인덱스가 포함되지 않음
        if (startIndex > targetIdx || endIndex < targetIdx) {
            return segmentTree[idx];
        }
        if (startIndex == endIndex) {
            segmentTree[idx] = value;
            return segmentTree[idx];
        }

        int midIndex = (startIndex + endIndex) / 2;
        long leftSum = changeValue(startIndex, midIndex, idx * 2, targetIdx, value);
        long rightSum = changeValue(midIndex + 1, endIndex, idx * 2 + 1, targetIdx, value);

        return segmentTree[idx] = leftSum + rightSum;
    }

    public static long makeSegmentTree(int startIndex, int endIndex, int idx) {
        if (startIndex == endIndex) {
            segmentTree[idx] = inputList[startIndex];
            return inputList[startIndex];
        }
        int midIndex = (startIndex + endIndex) / 2;
        long leftSum = makeSegmentTree(startIndex, midIndex, idx * 2);
        long rightSum = makeSegmentTree(midIndex + 1, endIndex, idx * 2 + 1);

        return segmentTree[idx] = leftSum + rightSum;


    }
}
