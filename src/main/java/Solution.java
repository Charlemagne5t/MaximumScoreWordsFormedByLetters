import java.util.Arrays;

public class Solution {
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
    }
    int dfs(int[] letCount, String[] words, int[] score, int i){

    }
    int canForm(String s, int[] letCount, int[] score ) {
        int[] copy = Arrays.copyOf(letCount, letCount.length);
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            copy[s.charAt(i) - 'a']--;
            if(copy[s.charAt(i) - 'a'] < 0) {
                return -1;
            }
            res += score[s.charAt(i) - 'a'];
        }
        return res;
    }
}