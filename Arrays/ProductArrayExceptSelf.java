package Arrays;

// =====================================================
// 238. Product of Array Except Self
// =====================================================

public class ProductArrayExceptSelf {

    public int[] productExceptSelf(int[] nums){
        int n = nums.length;
        int[] answer = new int[n];

        answer[0] = 1;
        for (int i = 1; i<nums.length; i++ ){
            answer[i] = answer[i-1] * nums[i-1];
        }
        int right = nums[n-1];
        for(int i = n-2; i >= 0; i--){
            answer[i] = answer[i] * right;
            right *= nums[i];
        }

        return answer;
    }
}
