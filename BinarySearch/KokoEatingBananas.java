package BinarySearch;

// =====================================================
// 875. Koko Eating Bananas
// =====================================================

import java.util.Arrays;

public class KokoEatingBananas {

    public int hoursToFinish(int[] piles, int k) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k;
        }
        return hours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        // Binary search for the minimum k
        int left = 1, right = Integer.MIN_VALUE;

        // Find the maximum number of bananas in any pile
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        // Binary search between 1 and the maximum pile size
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (hoursToFinish(piles, mid) <= h) {
                right = mid;  // mid is a valid eating speed, try smaller values
            } else {
                left = mid + 1;  // mid is too small, try larger values
            }
        }

        return left;  // left is the minimum speed that allows finishing in h hours
    }
}
