package 개념.세그먼트트리;

import java.lang.Math;
import java.math.BigInteger;
import java.util.Arrays;

public class segment_tree_recursive {

    public static class SegmentTree {
        int level = 0;
        int length = 0;
        int[] inputList;
        int inputListLength;
        int inputStartIndex = 0;
        int inputEndIndex = 0;
        int treeIndex = 1;
        String calculationMethod;
        int[] resultList;

        public SegmentTree(int[] inputList, String calculationMethod) {
            this.calculationMethod = calculationMethod;
            this.inputListLength = inputList.length;
            this.inputEndIndex = this.inputListLength - 1;
            this.inputList = new int[this.inputListLength];

            System.arraycopy(inputList, 0, this.inputList, 0, this.inputListLength);

            this.level = (int) Math.ceil(Math.log(this.inputListLength) / Math.log(2)) + 1;
            this.length = (int) Math.pow(2, this.level);
            this.resultList = new int[this.length];

            this.make(0, this.inputListLength-1, 1);

        }

        public int gcd(int leftResult, int rightResult) {
            if (rightResult == 0) {
                return leftResult;
            }

            return this.gcd(rightResult, leftResult % rightResult);
        }

        public int method(int leftResult, int rightResult) {
            switch (this.calculationMethod) {
                case "sum":
                    return leftResult + rightResult;
                case "max":
                    return Math.max(leftResult, rightResult);
                case "gcd":
                    return this.gcd(leftResult, rightResult);
            }

            return leftResult + rightResult;
        }

        public int updateProcess(int inputStartIndex, int inputEndIndex, int treeIndex, int updateIndex, int updateValue) {
            //구간에서 벗어나면 값 그대로 리턴
            if ((updateIndex < inputStartIndex) || (updateIndex > inputEndIndex)) {
                return this.resultList[treeIndex];
            }

            //리프노드라면 바꿔...?
            if (inputStartIndex == inputEndIndex) {
                this.resultList[treeIndex] = updateValue;
                return this.resultList[treeIndex];
            }

            int inputMidIndex = (inputStartIndex + inputEndIndex) / 2;
            int leftResult = this.updateProcess(inputStartIndex, inputMidIndex, treeIndex * 2, updateIndex, updateValue);
            int rightResult = this.updateProcess(inputMidIndex + 1, inputEndIndex, treeIndex * 2 + 1, updateIndex, updateValue);

            this.resultList[treeIndex] = this.method(leftResult, rightResult);

            return this.resultList[treeIndex];
        }

        public void update(int updateIndex, int updateValue) {
            this.treeIndex = 1;
            this.inputList[updateIndex] = updateValue;

            this.updateProcess(this.inputStartIndex, this.inputEndIndex, this.treeIndex, updateIndex, updateValue);
        }

        public int getRangeProcess(int inputStartIndex, int inputEndIndex, int treeIndex, int rangeStartIndex, int rangeEndIndex) {
            //완전하게 벗어난 값은 무효
            if ((inputEndIndex < rangeStartIndex) || (inputStartIndex > rangeEndIndex)) {
                return 0;
            }

            //구간에 완전하게 들어
            //더이상 내려가지않고 그냥 값 가져옴
            if ((inputStartIndex >= rangeStartIndex) && (inputEndIndex <= rangeEndIndex)) {
                return this.resultList[treeIndex];
            }

            int inputMidIndex = (inputStartIndex + inputEndIndex) / 2;

            int leftResult = this.getRangeProcess(inputStartIndex, inputMidIndex, treeIndex * 2, rangeStartIndex, rangeEndIndex);
            int rightResult = this.getRangeProcess(inputMidIndex + 1, inputEndIndex, treeIndex * 2 + 1, rangeStartIndex, rangeEndIndex);

            return this.method(leftResult, rightResult);
        }

        public int getRange(int rangeStartIndex, int rangeEndIndex) {
            return this.getRangeProcess(this.inputStartIndex, this.inputEndIndex, this.treeIndex, rangeStartIndex, rangeEndIndex);
        }

        public int make(int inputStartIndex, int inputEndIndex, int treeIndex) {
            //1. 리프노드라면 값을 채우고 가지고 올라옴(리턴)
            if (inputStartIndex == inputEndIndex) {
                this.resultList[treeIndex] = this.inputList[inputStartIndex];
                return this.resultList[treeIndex];
            }
            //2. 중간 인덱스값(루트..?)
            int inputMidIndex = (inputStartIndex + inputEndIndex) / 2;
            //3.왼쪽,오른쪽 값 가져오기
            int left_result = this.make(inputStartIndex, inputMidIndex, treeIndex * 2);
            int right_result = this.make(inputMidIndex + 1, inputEndIndex, treeIndex * 2 + 1);

            //4. 두값의 연산결과를 저장
            this.resultList[treeIndex] = this.method(left_result, right_result);
            //5. 해당 값을 리턴
            return this.resultList[treeIndex];
        }

    }

    public static void main(String[] args) {
        int[] numberList = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        SegmentTree segmentTree = new SegmentTree(numberList, "sum");
        System.out.println(Arrays.toString(segmentTree.resultList));
        System.out.println(segmentTree.getRange(3, 5));
        segmentTree.update(4, 7);
        System.out.println(Arrays.toString(segmentTree.resultList));
        System.out.println(segmentTree.getRange(3, 5));
    }
}