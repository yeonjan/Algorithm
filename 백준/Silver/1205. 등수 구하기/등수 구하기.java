import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Long inputScore = Long.parseLong(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        List<Long> ranking = new LinkedList<>();

        if (N != 0) st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ranking.add(Long.parseLong(st.nextToken()));

        }
        ranking.sort(Collections.reverseOrder());

        int rank = ranking.size();
        for (int idx = 0; idx < ranking.size(); idx++) {
            Long score = ranking.get(idx);
            if (score <= inputScore) {
                rank = idx;
                break;
            }
        }
        ranking.add(rank, inputScore);

        if (ranking.size() > P && ranking.get(ranking.size() - 1).equals(inputScore)) {
            rank = -1;
        }else  rank=rank+1;

        System.out.println(rank);

    }


}
