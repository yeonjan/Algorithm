package ssafy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 가위바위보 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("가위바위보 게임을 시작합니다.아래 보기 중 하나를 고르세요.");
        System.out.println("1. 5판 3승 \n2. 3판 2승 \n3. 1판 1승");
        System.out.println("번호를 입력하세요");
        int round = 0;
        int end = 0;

        switch (Integer.parseInt(br.readLine())) {
            case 1:
                round = 5;
                end = 3;
                break;
            case 2:
                round = 3;
                end = 2;
                break;
            case 3:
                round = 1;
                end = 1;
                break;
        }

        int win = 0;
        int tie = 0;
        for (int i = 0; i < round; i++) {
            int com = (int) (Math.random() * 3) + 1;
            System.out.println("가위바위보 중 하나 입력: ");
            switch (br.readLine()) {
                case "가위":
                    if (com == 2) {
                        System.out.println("승");
                        win++;
                    } else if (com == 1) {
                        tie++;
                        System.out.println("무승부");
                    } else {
                        System.out.println("패");
                    }
                    break;
                case "바위":
                    if (com == 3) {
                        System.out.println("승");
                        win++;
                    } else if (com == 2) {
                        tie++;
                        System.out.println("무승부");
                    } else {
                        System.out.println("패");
                    }
                    break;
                case "보":
                    if (com == 1) {
                        System.out.println("승");
                        win++;
                    } else if (com == 3) {
                        tie++;
                        System.out.println("무승부");
                    } else {
                        System.out.println("패");
                    }
                    break;
            }
            if (win == end) break;
        }
        if (win > round / 2) System.out.println("### 사용자 승!!!");
        else if (round - win - tie > round / 2) System.out.println("###컴퓨터 승!!!");
        else System.out.println("### 무승부");

        //숫자출력1
/*        int num = 1;
        for (int i = 5; i > 0; i--) {
            for (int j = num; j < num + i; j++) {
                sb.append(j);
            }
            num += i;
            sb.append("\n");
        }
        System.out.println(sb);*/

        //숫자출력2
/*        int num = 1;
        for (int i = 5; i > 0; i-=2) {
            for (int j = num; j < num + i; j++) {
                sb.append(j);
            }
            num += i;
            sb.append("\n");
        }
        for (int i = 3; i < 6; i+=2) {
            for (int j = num; j < num + i; j++) {
                sb.append(j);
            }
            num += i;
            sb.append("\n");
        }
        System.out.println(sb);*/
    }
}
