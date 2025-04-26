package TwoPointers;

// =====================================================
// 11. Container With Most Water
// =====================================================

public class MaxWaterContainer {
    public int maxArea(int[] height){
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        while (left<right){
            if(height[left] < height[right]){
                maxArea = Math.max(height[left]  * (right-left), maxArea);
                left++;
            }else {
                maxArea = Math.max(height[right]  * (right-left), maxArea);
                right--;
            }
        }
        return maxArea;
    }
}
