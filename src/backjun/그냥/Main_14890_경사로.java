package backjun.그냥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_14890_경사로 {
    static int[][] map1;
    static int[][] map2;
    static int n;
    static int l;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        map1 = new int[n + 1][n + 1];
        map2 = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int input = Integer.parseInt(st.nextToken());
                map1[i][j] = input;
                map2[j][i] = input;
            }
        }
        for (int i = 0; i < n; i++) {
            ArrayList<int[]> list1 = setRoadList(map1, i);
            ArrayList<int[]> list2 = setRoadList(map2, i);

            //list 돌며 낮은것의 수가 l 보다 크면 통과
            canGo(list1);
            canGo(list2);
        }
        System.out.println(cnt);
    }

    public static ArrayList<int[]> setRoadList(int[][] map, int h) {
        ArrayList<int[]> roadList = new ArrayList<>();
        int last = map[h][0];
        int cnt = 1;
        for (int i = 1; i <= n; i++) {
            int cur = map[h][i];
            if (cur == last) {
                cnt++;
                continue;
            }

            roadList.add(new int[]{last, cnt});
            cnt = 1;
            last = cur;
        }
        return roadList;

    }

    public static void canGo(ArrayList<int[]> list) {
        int size = list.size();
        for (int i = 1; i < size; i++) {
            int[] road = list.get(i - 1);
            int[] nextRoad = list.get(i);
            if (!canInstall(road, nextRoad)) {
                return;
            }

            if (road[0] > nextRoad[0] && nextRoad[1] >= l) {
                list.set(i, new int[]{nextRoad[0], nextRoad[1] - l});
            }
        }
        cnt++;
    }

    public static boolean canInstall(int[] firstRoad, int[] nextRoad) {
        return (firstRoad[0] == nextRoad[0] + 1 && nextRoad[1] >= l) || (firstRoad[0] + 1 == nextRoad[0] && firstRoad[1] >= l);
    }

}

//[3,6]
//        [2],[3,5]
//        [2,3][3,1][2,1][3,1]