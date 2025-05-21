package DailyChallenge;

// =====================================================
// 3355. Zero Array Transformation I
// =====================================================

public class ZeroArrayTransformation_I_14 {

    public boolean isZeroArray(int[] nums, int[][] queries){

        int n = nums.length;
        int[] diff = new int[n];

        for (int i = 0; i <queries.length; i++){
            int start = queries[i][0];
            int end = queries[i][1];

            diff[start]++;
            if(end+1 < n){
                diff[end+1]--;
            }
        }

        int sum = 0;
        for (int i = 0; i < diff.length; i++){
            sum += diff[i];
            if (sum < nums[i])
                return false;
        }
        return true;
    }


}
