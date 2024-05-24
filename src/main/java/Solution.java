public class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] letCount = new int[26];
        for(int i = 0; i < letters.length; i++) {
            letCount[letters[i] - 'a']++;
        }

    }
}
