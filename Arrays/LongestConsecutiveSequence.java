package Arrays;

// =====================================================
// 128. Longest Consecutive Sequence
// =====================================================

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(0);
        int count = 0;
        Arrays.sort(nums);

        for(int i = 0; i<nums.length-1; i++){
            if (nums[i] < nums[i+1] -1) {
                maxHeap.add(count+1);
                count = 0;
            };
            if(nums[i] == nums[i+1]) continue;
            count++;
        }

        return maxHeap.poll();
    }
}
