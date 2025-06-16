package Arrays;

// =====================================================
// 220. Contains Duplicate III
// =====================================================

import java.util.TreeSet;

public class ContainsDuplicate3 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff){

        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];

            // Look for any number in range [num - valueDiff, num + valueDiff]

            //floor(x): Greatest element ≤ x
            Long floor = set.floor(num + valueDiff);
            //ceiling(x): Smallest element ≥ x
            Long ceiling = set.ceiling(num - valueDiff);

            if ((floor != null && floor >= num) || (ceiling != null && ceiling <= num)) {
                return true;
            }

            set.add(num);

            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }

        return false;
    }
}
