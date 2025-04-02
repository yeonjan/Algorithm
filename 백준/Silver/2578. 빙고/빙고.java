import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int MAP_SIZE = 5;
    static Map<Integer, int[]> map = new HashMap<>();
    static int[][] delta = {{0, 1}, {1, 0}, {1, 1}};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int gameRound = 0;

        Queue<Integer> callList = new LinkedList<>();
        boolean[][] bingoMap = new boolean[MAP_SIZE][MAP_SIZE];

        for (int i = 0; i < MAP_SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < MAP_SIZE; j++) {
                map.put(Integer.valueOf(st.nextToken()), new int[]{i, j});

            }
        }

        for (int i = 0; i < MAP_SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < MAP_SIZE; j++) {
                callList.add(Integer.parseInt(st.nextToken()));
            }
        }
        while (!callList.isEmpty()) {
            gameRound++;
            Integer num = callList.poll();
            callNum(num, bingoMap);

            if (isBingo(bingoMap)) {
                break;
            }
        }


        System.out.println(gameRound);

    }


    public static void callNum(int num, boolean[][] bingoMap) {
        int[] position = map.get(num);
        bingoMap[position[0]][position[1]] = true;
    }

    public static boolean isBingo(boolean[][] bingoMap) {
        int bingoCount = 0;

        //옆으로
        boolean right = true;
        boolean down = true;
        boolean rightDown = true;
        boolean leftDown = true;

        for (int i = 0; i < MAP_SIZE; i++) {
            right = true;
            down = true;
            for (int j = 0; j < MAP_SIZE; j++) {
                //오른쪽
                if (!bingoMap[i][j]) right = false;
                //아래
                if (!bingoMap[j][i]) down = false;
            }
            //오른쪽 아래
            if (!bingoMap[i][i]) rightDown = false;
            //왼쪽 아래
            if (!bingoMap[i][MAP_SIZE - i - 1]) leftDown = false;

            if (right) bingoCount++;
            if (down) bingoCount++;
        }

        if (rightDown) bingoCount++;
        if (leftDown) bingoCount++;
        return bingoCount >= 3;

    }

}
