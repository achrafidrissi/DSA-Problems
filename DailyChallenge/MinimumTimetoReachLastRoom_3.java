package DailyChallenge;

// =====================================================
// 3341. Find Minimum Time to Reach Last Room I
// =====================================================

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumTimetoReachLastRoom_3 {
    public int minTimeToReach(int[][] moveTime){
        int n = moveTime.length;
        int m = moveTime[0].length;

        if(isAllZero(moveTime)){
            return n;
        }

        int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        int[][] visitedTime = new int[n][m];
        for (int[] row : visitedTime) Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        pq.offer(new int[]{0,0,0});
        visitedTime[0][0] = 0;

        while (!pq.isEmpty()){
            int[] curr = pq.poll();
            int time = curr[0], x = curr[1], y = curr[2];
            if(x == n-1 && y == m-1) return time;

            for (int[] dir : directions){
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 ||  ny < 0 || nx >= n || ny >= m) continue;

                int currentTime = Math.max(time+1, moveTime[nx][ny]);
                if(currentTime < visitedTime[nx][ny]){
                    visitedTime[nx][ny] = currentTime;
                    pq.offer(new int[]{currentTime, nx, ny});
                }
            }
        }
        return -1;
    }

    private boolean isAllZero(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    return false; // Found a non-zero value
                }
            }
        }
        return true; // All values were zero
    }
}
