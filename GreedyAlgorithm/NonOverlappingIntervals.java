package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals){

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int start = intervals[0][0];
        int end = intervals[0][1];
        int eraseCount = 0;

        for (int i = 1; i < intervals.length; i++){
            if(end > intervals[i][0] && start < intervals[i][1] ){
                eraseCount++;
                start = intervals[i][0];
                end = intervals[i][1];
            }else {
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            }
        }
        return eraseCount;
    }
}
