package Arrays;

// =====================================================
// 217. Contains Duplicate
// =====================================================

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {

    public boolean containDuplicates(int[] nums){

        //Version 1
        Arrays.sort(nums);
        for (int i = 0; i <nums.length - 1; i++){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }

    //Version 2
    public boolean containDuplicates_2(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true; // duplicate found
            }
            seen.add(num);
        }
        return false; // no duplicates
    }
}
