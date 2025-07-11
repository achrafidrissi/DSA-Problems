package TwoPointers;

// =====================================================
// 680. Valid Palindrome II
// =====================================================

public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        return isValidPalindrome(s, 0, s.length()-1, false);
    }

    public boolean isValidPalindrome(String s, int left, int right, boolean skipped) {
        while (left<right) {
            if(s.charAt(left) == s.charAt(right)){
                left++;right--;
            }else {
                if (skipped) return false;
                return isValidPalindrome(s, left+1, right, true) ||
                        isValidPalindrome(s, left, right-1, true);
            }

        }
        return true;
    }
}
