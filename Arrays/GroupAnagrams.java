package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, Integer> map = new HashMap<>();
        List<List<String>> anagrams = new ArrayList<>();
        int count =0;

        for (int i = 0; i < strs.length; i++){
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String str = new String(temp);
            if (!map.containsKey(str)){
                map.put(str, count++);
                List<String> anagram = new ArrayList<>();
                anagram.add(strs[i]);
                anagrams.add(anagram);
            }else {
                anagrams.get(map.get(str)).add(strs[i]);
            }
        }
        return anagrams;
    }
}
