package BinarySearch;

// =====================================================
// 35. Search Insert Position
// =====================================================

import java.util.HashSet;
import java.util.Set;

public class SearchInsertPos {
    public int searchInsert(int[] nums, int target){

        int left = 0, right = nums.length-1;

        while (left<=right){
            int mid = left + (right-left)/2;

            if(nums[mid]==target){
                return mid;
             }else if (nums[mid] < target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }
}
