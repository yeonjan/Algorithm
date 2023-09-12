package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_2174_로봇시뮬레이션 {
    static int A;
    static int B;
    static int N;
    static int M;
    static int[][] map;
    static int[][] delta = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}}; //NWSE {dy,dx}
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Robot> robots = new ArrayList<>();

    static class Robot {
        int x;
        int y;
        int direction;

        public Robot(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        public void move(int dx, int dy) {
            map[dy][dx] = map[this.y][this.x];
            map[this.y][this.x] = 0;
            this.x = dx;
            this.y = dy;

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        map = new int[B][A];
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> directionMap = getDirectionMap();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int d = directionMap.get(st.nextToken());
            map[y][x] = i + 1;
            robots.add(new Robot(x, y, d));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            boolean isOk = command(Integer.parseInt(st.nextToken()), st.nextToken(), Integer.parseInt(st.nextToken()));
            if (!isOk) {
                break;
            }
        }
        System.out.println(sb.length() == 0 ? "OK" : sb.toString());


    }

    private static HashMap<String, Integer> getDirectionMap() {
        HashMap<String, Integer> directionMap = new HashMap<>();
        directionMap.put("N", 0);
        directionMap.put("W", 1);
        directionMap.put("S", 2);
        directionMap.put("E", 3);
        return directionMap;
    }

    public static boolean command(int robotNum, String cmd, int cnt) {
        Robot robot = robots.get(robotNum - 1);

        //회전인 경우
        if (cmd.equals("L") || cmd.equals("R")) {
            robot.direction = changeDirection(cmd, robot.direction, cnt);
            return true;
        }

        //직진인 경우
        int dx = robot.x;
        int dy = robot.y;
        for (int i = 0; i < cnt; i++) {
            dx += delta[robot.direction][1];
            dy += delta[robot.direction][0];
            if (dx < 0 || dy < 0 || dx >= A || dy >= B) {
                sb.append("Robot ").append(robotNum).append(" crashes into the wall\n");
                return false;
            }
            if (map[dy][dx] != 0) {
                sb.append("Robot ").append(robotNum).append(" crashes into robot ").append(map[dy][dx]).append("\n");
                return false;
            }
        }
        robot.move(dx, dy);
        return true;

    }

    public static int changeDirection(String cmd, int lastDirection, int cnt) {
        if (cmd.equals("L")) {
            return (lastDirection + cnt) % 4;
        }
        return (100 + (lastDirection - cnt)) % 4;

    }

}
