import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static class Snake {
        int direction;
        LinkedList<int[]> body = new LinkedList<>();

        public Snake() {
            this.direction = 0;
            this.body.add(new int[]{1, 1});
        }

        public void changeDirection(int direct) {
            this.direction = (delta.length + this.direction + direct) % delta.length;
        }
    }

    public static class Board {
        int time;
        int n;
        int[][] map;
        Snake snake;

        public Board(int n, int[][] map, Snake snake) {
            this.time = 0;
            this.n = n;
            this.map = map;
            this.snake = snake;
            map[snake.body.getFirst()[0]][snake.body.getFirst()[1]] = 1;

        }


        private boolean move() {
            time++;
            //1. 머리 이동
            int[] head = snake.body.getFirst();
            int dr = head[0] + delta[snake.direction][0];
            int dc = head[1] + delta[snake.direction][1];

            //1-1. 벽 충돌감지
            if (dr < 1 || dc < 1 || dr > n || dc > n) return false;

            //1-2. 몸통 충돌감지
            if (map[dr][dc] == 1) return false;


            //2. 사과가 없는 경우 꼬리 정리
            if (map[dr][dc] != -1) {
                int[] tail = snake.body.getLast();
                map[tail[0]][tail[1]] = 0;
                snake.body.removeLast();
            }

            map[dr][dc] = 1;
            snake.body.addFirst(new int[]{dr, dc});

            return true;
        }

        private void changeDirection(String direction) {
            if (direction.equals("L")) {
                snake.changeDirection(-1);
            } else if (direction.equals("D")) {
                snake.changeDirection(1);
            }
        }

        public void game(String[][] directionInfo) {
            //방향 전환 포함
            for (String[] dir : directionInfo) {
                int X = Integer.parseInt(dir[0]);
                String C = dir[1];

                while (this.time < X) {
                    if (!this.move()) return;
                }
                this.changeDirection(C);
            }

            //일반
            while (this.move()) {
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[][] map = new int[N + 1][N + 1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = -1;
        }
        Board board = new Board(N, map, new Snake());

        int L = Integer.parseInt(br.readLine());
        String[][] directionInfo = new String[L][2];
        for (int i = 0; i < L; i++) {
            directionInfo[i] = br.readLine().split(" ");
        }

        board.game(directionInfo);
        System.out.println(board.time);
    }


}
