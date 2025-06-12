package HackerRankProbs;

import java.util.Collections;
import java.util.List;

public class EfficientJanitor {

    public int efficientJanitor(List<Float> weight) {
        Collections.sort(weight); // sort ascending
        int left = 0;
        int right = weight.size() - 1;
        int trips = 0;

        while (left <= right) {
            if (weight.get(left) + weight.get(right) <= 3.00f) {
                left++;
                right--;
            } else {
                right--;
            }
            trips++;
        }

        return trips;
    }
}
