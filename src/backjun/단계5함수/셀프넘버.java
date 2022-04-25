package backjun.단계5함수;

public class 셀프넘버 {
    public static int d(int n) {
        int sum = n;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        boolean[] check = new boolean[10001];

        for (int i = 1; i < 10001; ++i) {
            int n = d(i);
            if (n < 10001) check[n] = true;
        }

        for (int i = 1; i < 10001; ++i) {
            if(!check[i]) sb.append(i).append("\n");
        }

        System.out.println(sb);
    }

}
