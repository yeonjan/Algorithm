package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_2632_피자판매 {
    static int wantSize;
    static int m;
    static int n;
    static int ans = 0;
    static int[] pizzaA;
    static int[] pizzaB;
    static HashMap<Integer, Integer> pizzaAMap = new HashMap<>();
    static HashMap<Integer, Integer> pizzaBMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        wantSize = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        pizzaA = new int[m];
        pizzaB = new int[n];

        for (int i = 0; i < m; i++) {
            pizzaA[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            pizzaB[i] = Integer.parseInt(br.readLine());
        }

        getPrefixSum(m, pizzaA, pizzaAMap);
        getPrefixSum(n, pizzaB, pizzaBMap);

        for (Integer pieceA : pizzaAMap.keySet()) {
            int pieceB = wantSize - pieceA;
            if (pizzaBMap.containsKey(pieceB)) {
                ans += (pizzaAMap.get(pieceA) * pizzaBMap.get(pieceB));
            }

        }


        System.out.println(ans);

    }


    private static void getPrefixSum(int size, int[] pizza, HashMap<Integer, Integer> pizzaMap) {
        int total = 0;
        for (int i = 0; i < size; i++) {
            total += pizza[i];
            int sum = pizza[i];
            pizzaMap.put(sum, pizzaMap.getOrDefault(sum, 0) + 1);
            for (int j = i + 1; j < size + i - 1; j++) {
                sum += pizza[j % size];
                pizzaMap.put(sum, pizzaMap.getOrDefault(sum, 0) + 1);
            }
        }
        pizzaMap.put(total, 1);
        pizzaMap.put(0, 1);

    }
}

