package HackerRankProbs;

import java.util.List;

public class FlippingTheMatrix {

    public static int flippingMatrix(List<List<Integer>> matrix) {
        int n = matrix.size() / 2;
        int maxSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int topLeft     = matrix.get(i).get(j);
                int topRight    = matrix.get(i).get(2 * n - 1 - j);
                int bottomLeft  = matrix.get(2 * n - 1 - i).get(j);
                int bottomRight = matrix.get(2 * n - 1 - i).get(2 * n - 1 - j);

                maxSum += Math.max(
                        Math.max(topLeft, topRight),
                        Math.max(bottomLeft, bottomRight)
                );
            }
        }

        return maxSum;
    }

}
