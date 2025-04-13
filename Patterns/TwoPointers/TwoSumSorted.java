package Patterns.TwoPointers;

// =====================================================
// 167. Two Sum II - Input Array Is Sorted
// =====================================================

public class TwoSumSorted {
    public int[] twoSum(int[] numbers, int target){
        int left = 0;
        int right = numbers.length - 1;
        while (left < right){
            int somme = numbers[left]+numbers[right];
            if( somme == target){
                return new int[]{left +1, right +1};
            } else if (somme > target) {
                right--;
            }else{
                left++;
            }
        }
        return new int[]{};
    }
}
