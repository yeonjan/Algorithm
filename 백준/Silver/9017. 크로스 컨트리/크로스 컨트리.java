import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static class Team implements Comparable<Team> {
        int code;
        int[] players = new int[6];
        int totalScore = 0;
        int countEnded = 0;

        Team(int code) {
            this.code = code;
        }

        public void addPlayer(int score) {
            if (countEnded < 4) totalScore += score;
            players[countEnded++] = score;
        }

        @Override
        public int compareTo(Team o) {
            if (totalScore == o.totalScore) {
                return players[4] - o.players[4];
            }
            return totalScore - o.totalScore;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] result = br.readLine().split(" ");
            Map<Integer, Team> teamMap = new HashMap<>();
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int i = 0; i < N; i++) {
                int player = Integer.parseInt(result[i]);
                countMap.put(player, countMap.getOrDefault(player, 0) + 1);
            }

            int score = 1;
            for (int i = 0; i < N; i++) {
                int player = Integer.parseInt(result[i]);
                if (!countMap.get(player).equals(6)) continue;
                teamMap.putIfAbsent(player, new Team(player));
                teamMap.get(player).addPlayer(score);
                score++;
            }

            Optional<Team> winner = teamMap.values().stream()
                    .sorted().findFirst();
            sb.append(winner.get().code).append("\n");
        }
        System.out.println(sb);
    }


}