package BitMasking;

// =====================================================
// 78. Subsets
// =====================================================

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums){

        int n = nums.length;
        int total = 1<<n;

        List<List<Integer>> results = new ArrayList<>();
        for (int mask = 0 ; mask < total; mask++){
            List<Integer> currentSet = new ArrayList<>();
            for (int j = 0; j < n; j++){
                if( ( mask & (1<<j) ) != 0){
                    currentSet.add(nums[j]);
                }
            }
            results.add(currentSet);
        }
        return results;
    }
}
