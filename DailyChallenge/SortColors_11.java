package DailyChallenge;

// =====================================================
// 75. Sort Colors
// =====================================================

public class SortColors_11 {

    public void sortColors(int[] nums){
        int temp;
        for (int i = 0; i < nums.length - 1; i++){
            for (int j = i+1 ; j < nums.length; j++){
                if(nums[i] > nums[j]){
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
