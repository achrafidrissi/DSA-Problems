package Arrays;

// =====================================================
// 219. Contains Duplicate II
// =====================================================

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate2 {

    public boolean containsNearbyDuplicate(int[] nums, int k){
        Set<Integer> window = new HashSet<>();
        for(int i = 0; i <nums.length; i++){
            if(i>k){
                window.remove(nums[i-k-1]);
            }
            if(!window.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}
