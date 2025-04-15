package Patterns.SlidingWindow;

// =====================================================
// 643. Maximum Average Subarray I
// =====================================================

public class MaxAverageSubarray {
    public double findMaxAverage(int[] nums, int k){
        double maxSum = 0;
        int windowSum = 0;
        for(int i = 0; i<k; i++){
            windowSum += nums[i];
        }
        maxSum = windowSum;
        for(int i = k; i<nums.length;i++){
            windowSum = windowSum + nums[i] - nums[i-k];
            maxSum = Math.max(maxSum,windowSum);
        }
        return maxSum/k;
    }
}
