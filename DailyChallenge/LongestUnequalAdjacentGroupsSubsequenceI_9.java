package DailyChallenge;

// =====================================================
// 2900. Longest Unequal Adjacent Groups Subsequence I
// =====================================================

import java.util.LinkedList;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequenceI_9 {

    public List<String> getLongestSubsequence(String[] words, int[] groups){
        List<String> LongestSubsequence = new LinkedList<>();

        LongestSubsequence.add(words[0]);

        if(words.length == 1){
            return LongestSubsequence;
        }

        for (int i = 0; i<groups.length-1 ; i++){
            if(groups[i] != groups[i+1]){
                LongestSubsequence.add(words[i+1]);
            }else {
                continue;
            }
        }
        return LongestSubsequence;
    }
}
