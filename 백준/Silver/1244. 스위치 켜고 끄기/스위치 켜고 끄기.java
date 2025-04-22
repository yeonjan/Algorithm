import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int switchCount;
        int studentCount;
        boolean[] stateArr;

        switchCount = Integer.parseInt(br.readLine());
        stateArr = new boolean[switchCount + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= switchCount; i++) {
            stateArr[i] = st.nextToken().equals("1");
        }

        studentCount = Integer.parseInt(br.readLine());
        for (int i = 1; i <= studentCount; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            changeSwitch(stateArr, gender, num);
        }

        for (int i = 1; i < stateArr.length; i++) {
            System.out.print(stateArr[i] ? 1 : 0);
            if (i % 20 == 0) System.out.println();
            else System.out.print(" ");
        }


        //남: 자연수*배수
        //여: 좌우대칭인 가장 긴 구간

    }

    public static void changeSwitch(boolean[] stateArr, int gender, int num) {


        switch (gender) {
            //남학생
            case 1:
                changeStateByBoy(stateArr, num);
                break;

            //여학생
            case 2:
                changeStateByGirl(stateArr, num);
                break;
        }


    }

    public static void changeStateByBoy(boolean[] stateArr, int num) {
        int idx = 1;
        while (num * idx < stateArr.length) {
            stateArr[num * idx] = !stateArr[num * idx];
            idx++;
        }
    }

    public static void changeStateByGirl(boolean[] stateArr, int num) {
        int idx = Math.min(num - 1, stateArr.length - 1 - num);

        for (int i = 0; i <= idx; i++) {
            if (i == 0) {
                stateArr[num] = !stateArr[num];
                continue;
            }

            if (stateArr[num - i] != stateArr[num + i]) {
                break;
            }

            stateArr[num - i] = !stateArr[num - i];
            stateArr[num + i] = !stateArr[num + i];


        }

    }
}