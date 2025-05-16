package DailyChallenge;

import java.util.Arrays;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequenceII_10 {

    private int hammingDistance(String word1, String word2){
        int count = 0;
        for (int i = 0; i<word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i)){
                count++;
            }
        }
        return count;
    }

    private boolean verifyConditions(String word1, String word2){
        if(word1.length() == word2.length()){
            if(hammingDistance(word1, word2) == 1){
                return true;
            }
        }
        return false;
    }

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups){
        int wordsLength = words.length;
        int[] list = new int[wordsLength];
        int[] parent = new int[wordsLength];
        int max_len = 1;
        int position = 0;

        Arrays.fill(list, 1);
        Arrays.fill(parent, -1);
        for (int i = 0; i < wordsLength - 1; i++){
            for (int j = i+1; j<wordsLength; j++){
                if(groups[i] != groups[j] && verifyConditions(words[i], words[j]) && list[j] < list[i] + 1 ){

                    list[j] = list[i] + 1;
                    parent[j] = i;
                        if(list[j] > max_len){
                            max_len = list[j];
                            position = j;
                        }
                    }
                }
        }

        String[] result = new String[max_len];
        int index = max_len - 1;

        while (position != -1){
            result[index] = words[position];
            index--;
            position = parent[position];
        }

        return Arrays.asList(result);
    }
}
