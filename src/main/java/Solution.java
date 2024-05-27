import java.util.Arrays;

public class Solution {
    int max = 0;
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] letCount = new int[26];
        for(int i = 0; i < letters.length; i++) {
            letCount[letters[i] - 'a']++;
        }
        int[] wordScores = new int[words.length];
        for(int i = 0; i < words.length; i++ ) {
            for (int j = 0; j < words[i].length(); j++) {
                wordScores[i] += score[words[i].charAt(j) - 'a'];
            }
        }
        dfs(letCount,words, wordScores, 0, 0);
        return max;
    }
    void dfs(int[] letCount, String[] words,  int[] wordScores, int mask, int curScore){
        for (int i = 0; i < words.length; i++) {
            if((mask & 1 << i) == 0 && canForm(words[i], letCount)) {
                for (int j = 0; j < words[i].length(); j++) {
                    letCount[words[i].charAt(j) - 'a']--;
                }
                max = Math.max(max, curScore + wordScores[i]);
                dfs(letCount, words, wordScores, mask | 1 << i, curScore + wordScores[i]);
                for (int j = 0; j < words[i].length(); j++) {
                    letCount[words[i].charAt(j) - 'a']++;
                }
            }
        }
    }
    boolean canForm(String s, int[] letCount) {
        int[] copy = Arrays.copyOf(letCount, letCount.length);
        for(int i = 0; i < s.length(); i++) {
            copy[s.charAt(i) - 'a']--;
            if(copy[s.charAt(i) - 'a'] < 0) {
                return false;
            }

        }
        return true;
    }
}