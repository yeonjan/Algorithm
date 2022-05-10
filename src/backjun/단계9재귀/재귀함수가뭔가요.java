package backjun.단계9재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 재귀함수가뭔가요 {
    static StringBuilder sb = new StringBuilder();
    static String[] str1 = {"\"재귀함수가 뭔가요?\"","\"재귀함수는 자기 자신을 호출하는 함수라네\""};
    static String[] str2 = {"\"재귀함수가 뭔가요?\"",
            "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
            "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.",
            "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\""};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append("\n");
        recursion(n, 0);
        sb.append("라고 답변하였지.");
        System.out.println(sb.toString());

    }

    public static void recursion(int n, int count) {
        if (n == 0) {
            for (String s : str1) {
                sb.append("____".repeat(count));
                sb.append(s).append("\n");
            }
            return;
        }

        for (String s : str2) {
            sb.append("____".repeat(count));
            sb.append(s).append("\n");
        }

        recursion(n-1,count+=1);

        sb.append("____".repeat(count));
        sb.append("라고 답변하였지.").append("\n");

    }
}
