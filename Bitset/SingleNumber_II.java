package Bitset;

// =====================================================
// 137. Single Number II
// =====================================================

public class SingleNumber_II {

    public int singleNumber(int[] nums){
        int result = 0;

        for (int i = 0; i < 32; i++){
            int bitCount = 0;

            for (int num : nums){
                if((num >> i & 1) == 1 ){
                    bitCount++;
                }
            }

            if(bitCount % 3 != 0){
                result |= (1 << i);
            }
        }
        return result;

    }
}

//
//public int singleNumber(int[] nums) {
//    int result = 0;
//
//    // Check each bit position (0 to 31)
//    for (int i = 0; i < 32; i++) {
//        int bitCount = 0;
//
//        for (int num : nums) {
//            // Check if the i-th bit is set in num
//            if ((num >> i & 1) == 1) {
//                bitCount++;
//            }
//        }
//
//        // If bitCount % 3 == 1, this bit belongs to the unique number
//        if (bitCount % 3 != 0) {
//            result |= (1 << i);  // Set that bit in result
//        }
//    }
//
//    return result;
//}
