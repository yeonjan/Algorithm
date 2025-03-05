import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int p, m;
    static List<Room> rooms = new ArrayList<>();

    static class Room {
        Player host;
        Boolean isOpen;
        List<Player> players;


        public Room(Player host) {
            this.host = host;
            this.players = new ArrayList<>();
            this.players.add(host);
            this.isOpen = this.players.size() < m;
        }

        public boolean canEnter(Player p) {
            if (!this.isOpen) return false;
            int std = this.host.level;
            return std - 10 <= p.level && p.level <= std + 10;
        }

        public void enter(Player p) {
            this.players.add(p);
            if (this.players.size() >= m) {
                isOpen = false;
            }

        }

        public void printPlayers() {
            Collections.sort(this.players);
            System.out.println(!this.isOpen ? "Started!" : "Waiting!");
            for (Player p : this.players) {
                System.out.println(p.level + " " + p.name);
            }
        }
    }

    static class Player implements Comparable<Player> {
        int level;
        String name;

        public Player(int level, String name) {
            this.level = level;
            this.name = name;
        }

        @Override
        public int compareTo(Player o) {
            return this.name.compareTo(o.name);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        roof:
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            Player player = new Player(Integer.parseInt(st.nextToken()), st.nextToken());
            for (Room room : rooms) {
                if (room.canEnter(player)) {
                    room.enter(player);
                    continue roof;
                }
            }
            rooms.add(new Room(player));
        }
        for (Room room : rooms) {
            room.printPlayers();
        }

    }



}