package backjun.단계11정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 나이순정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Member[] members = new Member[n];
        String[] member;
        for (int i = 0; i < n; ++i) {
            member = br.readLine().split(" ");
            members[i] = new Member(Integer.parseInt(member[0]), member[1], i);
        }

        Arrays.sort(members, new Comparator<Member>() {
            @Override
            public int compare(Member m1, Member m2) {
                return m1.age!=m2.age?m1.age-m2.age:m1.index-m2.index;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Member m : members) {
            sb.append(m.age).append(" ").append(m.name).append("\n");
        }
        System.out.println(sb);
    }

}
class Member {
    int age;
    String name;
    int index;

    public Member(int age, String name, int index) {
        this.age = age;
        this.name = name;
        this.index = index;
    }
}
