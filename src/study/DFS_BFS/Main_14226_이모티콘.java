package study.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main_14226_이모티콘 {
    static int S, ans = Integer.MAX_VALUE, next;
    static boolean[][] visited = new boolean[1001][1001];

    static class Node {
        int emojiCnt, clip, time;

        public Node(int emojiCnt, int clip, int time) {
            this.emojiCnt = emojiCnt;
            this.clip = clip;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
        visited[1][0] = true;
        bfs();
        System.out.println(ans);

    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(1, 0, 0));
        while (!queue.isEmpty()) {

            Node emoji = queue.poll();

            if (emoji.emojiCnt == S) {
                ans = Math.min(ans, emoji.time);
                continue;
            }


            //붙

            next = emoji.emojiCnt + emoji.clip;
            if (range(next) && !visited[next][emoji.clip]) {
                visited[next][emoji.clip] = true;
                queue.offer(new Node(next, emoji.clip, emoji.time + 1));
            }

            //복사

            if (range(next) && !visited[emoji.emojiCnt][emoji.emojiCnt]) {
                visited[emoji.emojiCnt][emoji.emojiCnt] = true;
                queue.offer(new Node(emoji.emojiCnt, emoji.emojiCnt, emoji.time + 1));
            }
            //삭제
            next = emoji.emojiCnt - 1;
            if (range(next) && !visited[next][emoji.clip]) {
                visited[next][emoji.clip] = true;
                queue.offer(new Node(next, emoji.clip, emoji.time + 1));
            }
        }
    }


    public static boolean range(int next) {
        if (next <= 0 || next > 1000) return false;
        return true;
    }
}

