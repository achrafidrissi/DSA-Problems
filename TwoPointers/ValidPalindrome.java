package TwoPointers;

// =====================================================
// 125. Valid Palindrome
// =====================================================

public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        char[] sentence = new char[s.length()];
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)>=65 && s.charAt(i)<=90 ){
                sentence[j] = (char) (s.charAt(i) + 32);
                j++;
            }else if((s.charAt(i)>=97 && s.charAt(i)<=122) || (s.charAt(i)>=48 && s.charAt(i)<=57)){
                sentence[j] = s.charAt(i);
                j++;
            }
        }

        int left = 0, right = j-1;
        while (left<right){
            if(sentence[left] != sentence[right]){
                return false;
            }
            left++;right--;
        }
        return true;
    }
}
