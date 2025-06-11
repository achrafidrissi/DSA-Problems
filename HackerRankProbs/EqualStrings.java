package HackerRankProbs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EqualStrings {
    public List<Integer> getRemovableIndices(String str1, String str2) {
        // Write your code here
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        int count = 0;

        while(i < str1.length()){
            if( (j==str2.length()) || (str1.charAt(i) != str2.charAt(j)) ){
                k = i;
                count++;
                i++;
            }else{
                i++;j++;
            }
        }
        if(count != 1 ){
            list.add(-1);
            return list;
        }
        list.add(k);
        while( (k-1 >= 0) && str1.charAt(k-1) == str1.charAt(k)){
            k--;
            list.add(k);
        }
        Collections.sort(list);
        return list;
    }
}
