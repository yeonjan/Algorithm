package study.공통문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1620_나는야_포켓몬_마스터_이다솜 {
    static int N, M;
    static Map<String, String> pokeMonMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String pokemon = br.readLine();
            pokeMonMap.put(String.valueOf(i), pokemon);
            pokeMonMap.put(pokemon,String.valueOf(i));
        }

        for (int i = 0; i < M; i++) {
            String ans=pokeMonMap.get(br.readLine());
            sb.append(ans).append("\n");
        }
        System.out.println(sb);

    }

}
