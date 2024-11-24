import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int k;

    static class Person implements Comparable<Person> {
        int num;
        int weight;
        int height;

        public Person(int num, int weight, int height) {
            this.num = num;
            this.weight = weight;
            this.height = height;
        }


        @Override
        public int compareTo(Person o) {
            if (this.weight > o.weight && this.height > o.height) {
                return 1;
            } else if (this.weight < o.weight && this.height < o.height) {
                return -1;
            } else return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        k = Integer.parseInt(br.readLine());
        List<Person> persons = new ArrayList<>();
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            Person p = new Person(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            persons.add(p);
        }


        for(Person p1: persons) {
            ans[p1.num]=1;
            for(Person p2:persons) {
                if(p1.compareTo(p2)<0) ans[p1.num]++;
            }
        }

        for (int i = 0; i < k; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();


    }
}