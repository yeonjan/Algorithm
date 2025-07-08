import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int start = str.length() / 2;
        int ans = 0;

        for (int i = start; i < str.length(); i++) {
            int palindrome = isPalindrome(str, i, false);
            int palindromeOdd = isPalindrome(str, i, true);

            if (palindrome == -1 && palindromeOdd == -1) continue;

            if (palindrome == -1) {
                ans = palindromeOdd;
                break;
            } else if (palindromeOdd == -1) {
                ans = palindrome;
                break;
            } else {
                ans = Math.min(palindrome, palindromeOdd);
                break;
            }


        }
        System.out.println(str.length() + ans);


    }


    public static int isPalindrome(String s, int idx, boolean isOdd) {
        int left = idx - 1;
        int right = isOdd ? idx + 1 : idx;

        while (0 <= left && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) return -1;
            left--;
            right++;
        }
        if (left < 0 && right < s.length()) return -1;
        return left + 1;
    }


}
