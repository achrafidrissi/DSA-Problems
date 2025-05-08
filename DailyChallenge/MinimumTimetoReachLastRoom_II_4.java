package DailyChallenge;

// =====================================================
// 3342. Find Minimum Time to Reach Last Room II
// =====================================================

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumTimetoReachLastRoom_II_4 {

    public int minTimeToReach(int[][] moveTime){
        int n = moveTime.length;
        int m = moveTime[0].length;
        int arriveTime = 0;

        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int[][] visited = new int[n][m];

        for (int[] row : visited) Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));

        pq.offer(new int[]{0,0,0});
        visited[0][0] = 0;

        while (!pq.isEmpty()){
            int[] curr = pq.poll();
            int time = curr[0], x = curr[1], y = curr[2];

            if( x == n-1 && y == m-1 ) return time;

            for (int[] dir : directions){
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                int nextStartTime = Math.max(time, moveTime[nx][ny]);

                if ((x+y) % 2 == 0) {
                    arriveTime = nextStartTime + 1;
                }else {
                    arriveTime = nextStartTime + 2;
                }
                if (arriveTime < visited[nx][ny]){
                    visited[nx][ny] = arriveTime;
                    pq.offer(new int[]{arriveTime, nx, ny});
                }
            }
        }
        return -1;
    }
}
