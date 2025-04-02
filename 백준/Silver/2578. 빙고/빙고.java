import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int MAP_SIZE = 5;
    static int[][] delta = {{0, 1}, {1, 0}, {1, 1}};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int gameRound = 0;
        int[][] map = new int[MAP_SIZE][MAP_SIZE];
        Queue<Integer> callList = new LinkedList<>();

        for (int i = 0; i < MAP_SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < MAP_SIZE; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
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
            callNum(num, map);

            if (isBingo(map)) {
                break;
            }
        }


        System.out.println(gameRound);

    }


    public static void callNum(int num, int[][] map) {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (map[i][j] == num) map[i][j] = 0;
            }
        }
    }

    public static boolean isBingo(int[][] map) {
        int bingoCount = 0;

        //옆으로
        loop:
        for (int r = 0; r < MAP_SIZE; r++) {
            for (int c = 0; c < MAP_SIZE; c++) {
                if (map[r][c] != 0) continue loop;
            }
            bingoCount++;
        }
        //아래로
        loop:
        for (int c = 0; c < MAP_SIZE; c++) {
            for (int r = 0; r < MAP_SIZE; r++) {
                if (map[r][c] != 0) continue loop;
            }
            if(c==4) System.out.println();
            bingoCount++;
        }
        //오른쪽 아래
        bingoCount++;
        for (int idx = 0; idx < MAP_SIZE; idx++) {
            if (map[idx][idx] != 0) {
                bingoCount--;
                break;
            }
        }
        //왼쪽 아래
        bingoCount++;
        for (int idx = 0; idx < MAP_SIZE; idx++) {
            if (map[idx][MAP_SIZE - idx - 1] != 0) {
                bingoCount--;
                break;
            }
        }
        return bingoCount >= 3;

    }

    //call Num -> 25
    // 빙고 check 25+25+10
}
