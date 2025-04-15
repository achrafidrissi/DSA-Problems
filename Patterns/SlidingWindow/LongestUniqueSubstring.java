package Patterns.SlidingWindow;

// =====================================================
// 3. Longest Substring Without Repeating Characters
// =====================================================

import java.util.HashMap;
import java.util.HashSet;

public class LongestUniqueSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> map = new HashSet<>();
        int start = 0, end = 0;
        int maxLength = 0;
        while(end<s.length()){
            if(!map.contains(s.charAt(end))){
                map.add(s.charAt(end));
                maxLength=Math.max(maxLength, end-start+1);
                end++;
            }else {
                map.remove(s.charAt(start));
                start++;
            }
        }
        return maxLength;
    }
}
