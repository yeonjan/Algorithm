import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Word implements Comparable<Word> {
        int idx;
        String word;

        public Word(int idx, String word) {
            this.idx = idx;
            this.word = word;
        }


        @Override
        public int compareTo(Word o) {
            if (this.word.compareTo(o.word) == 0) {
                return Integer.compare(this.idx, o.idx);
            }
            return this.word.compareTo(o.word);
        }

        public int countPrefix(Word o) {
            int max = Math.min(this.word.length(), o.word.length());
            int cnt = 0;
            for (int i = 0; i < max; i++) {
                if (this.word.charAt(i) != o.word.charAt(i)) {
                    break;
                }
                cnt++;
            }
            return cnt;
        }
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ans = new String[2];

        List<Word> words = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            words.add(new Word(i, br.readLine()));

        }
        Collections.sort(words);

        int max = 0;
        int minIdx = Integer.MAX_VALUE;
        for (int i = 0; i < words.size() - 1; i++) {
            for (int j = i + 1; j < words.size(); j++) {
                Word word1 = words.get(i);
                Word word2 = words.get(j);

                int prefixCnt = word1.countPrefix(word2);
                int idx = Math.min(word1.idx, word2.idx);

                if (prefixCnt == 0) break;


                if (max < prefixCnt) {
                    minIdx = idx;
                    max = prefixCnt;
                    setAns(ans, word1, word2);
                } else if (max == prefixCnt && idx < minIdx) {
                    minIdx = idx;
                    setAns(ans, word1, word2);

                }

            }


        }


        System.out.println(ans[0]);
        System.out.println(ans[1]);

    }

    public static void setAns(String[] ans, Word word1, Word word2) {
        if (word1.idx < word2.idx) {
            ans[0] = word1.word;
            ans[1] = word2.word;
        } else {
            ans[0] = word2.word;
            ans[1] = word1.word;
        }
    }

}
