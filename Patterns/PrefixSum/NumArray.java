package Patterns.PrefixSum;
// =====================================================
// 303. Range Sum Query - Immutable
// =====================================================

public class NumArray {
    private int[] Cumulative;

    public NumArray(int[] nums){
        Cumulative = new int[nums.length+1];
        for(int i = 1; i<nums.length + 1; i++){
            Cumulative[i] = Cumulative[i-1] + nums[i-1];
        }
    }

    public int sumRange(int left, int right){
        return this.Cumulative[right+1] - this.Cumulative[left];
    }
}
