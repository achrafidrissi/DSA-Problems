package Arrays;

// =====================================================
// 347. Top K Frequent Elements
// =====================================================

import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];

        // Step 1: Count frequencies
        for (int i = 0 ; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // Step 2: Sort entries by frequency (value) in descending order
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Step 3: Take top-k keys and put them into result[]
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey(); // ✅ write into result, not nums
        }

        return result;

    }
}
