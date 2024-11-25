import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static char[] vowel = {'a', 'e', 'i', 'o', 'u'};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("end")) break;

            print(input, isAcceptable(input));
        }
    }

    public static boolean isAcceptable(String word) {
        boolean hasVowel = isVowel(word.charAt(0));
        boolean latestIsVowel = hasVowel;
        int count = 1;
        for (int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);
            //3번 규칙
            if (c == word.charAt(i - 1)) {
                if (c != 'e' && c != 'o') return false;
            }
            boolean isVowel = isVowel(c);
            hasVowel = hasVowel || isVowel;
            if (latestIsVowel == isVowel) {
                count++;
            } else {
                count = 1;
            }
            if (count == 3) return false;
            latestIsVowel = isVowel;

        }
        //1번 규칙
        return hasVowel;
    }

    public static boolean isVowel(char word) {
        for (char v : vowel) {
            if (word == v) return true;
        }
        return false;
    }

    public static void print(String word, boolean isAcceptable) {
        System.out.print("<" + word + "> is ");
        if (isAcceptable) {
            System.out.println("acceptable.");
        } else {
            System.out.println("not acceptable.");
        }
    }
}