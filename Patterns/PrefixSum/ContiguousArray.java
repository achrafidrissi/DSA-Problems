package Patterns.PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public int findMaxLength(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(-1, 0);

        int maxLength = 0;
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum += (nums[i] == 0) ? -1 : 1;
            if(map.containsKey(sum)){
                int prevIndex = map.get(sum);
                maxLength = Math.max(maxLength, i - prevIndex);
            }else {
                map.put(sum, i);
            }
        }

        return maxLength;
    }
}
